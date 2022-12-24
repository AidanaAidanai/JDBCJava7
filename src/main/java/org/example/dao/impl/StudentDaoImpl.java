package org.example.dao.impl;

import org.example.config.JDBCConfig;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    public final Connection connection;

    public StudentDaoImpl() throws SQLException {
        connection = new JDBCConfig().getConnection();
    }

    public void createStudent() {
     String sql = """
             create table students(
             id serial primary key,
             name varchar(255),
             age int
             );
             """;
     try (Statement statement = connection.createStatement()) {
         statement.execute(sql);
     } catch (SQLException e) {
        e.printStackTrace();
     }
    }

    public void saveStudent(Student student) {
  String sql = """
          insert into students(name, age)values(? ?)
          """;
  try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    preparedStatement.setString(1,student.getName());
    preparedStatement.setInt(2,student.getAge());
    preparedStatement.execute();
  } catch (SQLException e) {
      e.printStackTrace();
  }
    }

    public Student findById(Long id) {
   String sql = """
           select from students where id = ?
           """;
   try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
       preparedStatement.setLong(1,id);
       ResultSet resultSet = preparedStatement.executeQuery();
       if(!resultSet.next()){
           System.out.println("not id");
       }
       Student student = new Student();
       student.setId(resultSet.getLong(1));
       student.setName(resultSet.getString(2));
       student.setAge(resultSet.getInt(3));
      return student;
   }catch (SQLException e){
       e.printStackTrace();
   }

        return null;
    }

    public void dropStudent() {
     String sql ="drop table students";
     try(Statement statement = connection.createStatement()){
         statement.execute(sql);
     } catch (SQLException e) {
         e.printStackTrace();
     }

    }

    public void cleanTable() {
   String sql = "truncate students";
   try (Statement statement = connection.createStatement()){
    statement.execute(sql);
   } catch (SQLException e) {
       e.printStackTrace();
   }
    }

    public void deleteById(Long id) {
      String sql = "delete from students where id = ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
         preparedStatement.setLong(1,id);
          preparedStatement.execute();


      } catch (SQLException e) {
          e.printStackTrace();
      }
    }

    public List<Student> findAllStudent() {
        String sql = "select * from students";
        List<Student>list = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
  ResultSet resultSet = statement.executeQuery(sql);
  while (resultSet.next()){
      Student student = new Student();
      student.setId(resultSet.getLong(1));
      student.setName(resultSet.getString("name"));
     student.setAge(resultSet.getInt(3));
      list.add(student);
  }
  return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateStudent(Long id, Student student) {
     String sql = "update from students  set name , age where id = ?";
     try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
     preparedStatement.setString(1, student.getName());
     preparedStatement.setInt(2,student.getAge());
     preparedStatement.setLong(3,student.getId());
     preparedStatement.execute();
     } catch (SQLException e) {
         e.printStackTrace();
     }
    }
}
