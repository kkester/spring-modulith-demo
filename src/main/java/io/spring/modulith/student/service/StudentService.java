package io.spring.modulith.student.service;

import io.spring.modulith.student.StudentModelPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentModelPort {

    private final StudentPersistPort studentPersistPort;

    public Student getStudentById(Long id) {
        return studentPersistPort.getStudent(id)
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> getAllStudents() {
        return studentPersistPort.retrieveAll();
    }

    public List<Student> createStudentWithName(String name) {
        Student student = Student.builder().name(name).build();
        studentPersistPort.saveStudent(student);
        return studentPersistPort.retrieveAll();
    }
}
