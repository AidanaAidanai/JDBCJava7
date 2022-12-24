package org.example.dao;

import org.example.model.Student;

import java.util.List;

public interface StudentDao {
    void createStudent();
    void saveStudent(Student student);
    Student findById(Long id);
    void dropStudent();
    void cleanTable();
    void deleteById(Long id);
    List<Student> findAllStudent();
    void updateStudent(Long id,Student student);

}
