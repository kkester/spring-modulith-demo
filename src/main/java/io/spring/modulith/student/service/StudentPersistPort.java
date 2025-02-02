package io.spring.modulith.student.service;

import io.spring.modulith.student.StudentRecord;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

import java.util.List;
import java.util.Optional;

@SecondaryPort
public interface StudentPersistPort {
    List<StudentRecord> retrieveAll();
    Optional<StudentRecord> getStudent(Long id);
    StudentRecord saveStudent(StudentRecord student);
}
