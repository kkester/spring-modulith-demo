package io.spring.modulith.student.api;

import io.spring.modulith.student.Student;
import io.spring.modulith.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.ApplicationServiceRing;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApplicationServiceRing
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<Student>> addStudent(@RequestBody String name) {
        List<Student> students = studentService.createStudentWithName(name);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }

    @PutMapping("/{studentId}/students/{courseId}")
    public Student assignStudentToCourse(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        return studentService.assignStudentToCourse(studentId, courseId);
    }
}
