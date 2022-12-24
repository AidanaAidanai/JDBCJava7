package org.example.service.Impl;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.model.Student;
import org.example.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    public StudentServiceImpl() throws SQLException {
    }

    public void createStudent() {
      studentDao.createStudent();
    }

    public void saveStudent(Student student) {
   studentDao.saveStudent(student);
    }

    public Student findById(Long id) {
      return studentDao.findById(id);
    }

    public void dropStudent() {
      studentDao.dropStudent();
    }

    public void cleanTable() {
    studentDao.cleanTable();
    }

    public void deleteById(Long id) {
    studentDao.deleteById(id);
    }

    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }

    public void updateStudent(Long id, Student student) {
    studentDao.updateStudent(id,student);
    }
}
