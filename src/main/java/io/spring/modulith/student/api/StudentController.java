package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentModelPort;
import io.spring.modulith.student.service.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentModelPort studentModelPort;
    private final StudentMapper studentMapper;

    @GetMapping
    public List<StudentRecord> getAllStudents() {
        return studentModelPort.getAllStudents().stream()
            .map(studentMapper::getRecordFromModel)
            .toList();
    }

    @GetMapping("/{id}")
    public StudentRecord getStudentById(@PathVariable Long id) {
        Student student = studentModelPort.getStudentById(id);
        return new StudentRecord(student.getId(), student.getName());
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<StudentRecord>> addStudent(@RequestBody String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is blank!");
        }
        List<StudentRecord> students = studentModelPort.createStudentWithName(name).stream()
            .map(studentMapper::getRecordFromModel)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
