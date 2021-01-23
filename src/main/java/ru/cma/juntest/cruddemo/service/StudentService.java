package ru.cma.juntest.cruddemo.service;

import ru.cma.juntest.cruddemo.model.entity.Student;

import java.util.List;

public interface StudentService {
    void deleteStudent(Long id);

    void saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudent(Long id);
}
