package io.spring.modulith.student;

import io.spring.modulith.student.service.Student;

import java.util.List;

public interface StudentModelPort {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    List<Student> createStudentWithName(String name);
}
