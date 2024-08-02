package io.spring.modulith.student.service;

import io.spring.modulith.student.ManageStudentsUseCase;
import io.spring.modulith.student.StudentRecord;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Application
@Service
@RequiredArgsConstructor
public class StudentService implements ManageStudentsUseCase {

    private final StudentPersistPort studentPersistPort;

    public StudentRecord getStudentById(Long id) {
        return studentPersistPort.getStudent(id)
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<StudentRecord> getAllStudents() {
        return studentPersistPort.retrieveAll();
    }

    public List<StudentRecord> createStudentWithName(String name) {
        StudentRecord student = new StudentRecord(null, name);
        studentPersistPort.saveStudent(student);
        return studentPersistPort.retrieveAll();
    }
}
