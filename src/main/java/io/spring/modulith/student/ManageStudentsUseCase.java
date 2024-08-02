package io.spring.modulith.student;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.List;

@PrimaryPort
public interface ManageStudentsUseCase {
    List<StudentRecord> getAllStudents();
    StudentRecord getStudentById(Long id);
    List<StudentRecord> createStudentWithName(String name);
}
