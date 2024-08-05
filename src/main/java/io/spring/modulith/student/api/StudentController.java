package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.layered.InterfaceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@InterfaceLayer
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentEntityMapper mapper;

    @GetMapping
    public List<StudentRecord> getAllStudents() {
        return studentService.getAllStudents().stream()
            .map(mapper::getModelFromEntity)
            .toList();
    }

    @GetMapping("/{id}")
    public StudentCoursesRecord getStudentById(@PathVariable Long id) {
        StudentEntity studentEntity = studentService.getStudentById(id);
        return new StudentCoursesRecord(studentEntity.getId(), studentEntity.getName(), Collections.emptyList());
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<StudentRecord>> addStudent(@RequestBody String name) {
        List<StudentRecord> students = studentService.createStudentWithName(name).stream()
            .map(mapper::getModelFromEntity)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }

    @PutMapping("/{studentId}/students/{courseId}")
    public StudentCoursesRecord assignStudentToCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        StudentEntity studentEntity = studentService.assignStudentToCourse(studentId, courseId);
        return new StudentCoursesRecord(studentEntity.getId(), studentEntity.getName(), Collections.emptyList());
    }
}
