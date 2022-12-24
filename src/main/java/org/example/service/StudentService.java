package org.example.service;

import org.example.model.Student;

import java.util.List;

public interface StudentService {
    void createStudent();
    void saveStudent(Student student);
    Student findById(Long id);
    void dropStudent();
    void cleanTable();
    void deleteById(Long id);
    List<Student> findAllStudent();
    void updateStudent(Long id,Student student);
}
