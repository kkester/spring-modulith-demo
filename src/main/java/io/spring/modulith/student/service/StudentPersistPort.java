package io.spring.modulith.student.service;

import java.util.List;
import java.util.Optional;

public interface StudentPersistPort {
    List<Student> retrieveAll();
    Optional<Student> getStudent(Long id);
    Student saveStudent(Student student);
}
