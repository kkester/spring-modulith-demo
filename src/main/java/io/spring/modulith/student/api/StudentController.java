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
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents().stream()
            .map(StudentDto.class::cast)
            .toList();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable(value = "id") Long id) {
        return (StudentDto) studentService.getStudentById(id);
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<StudentDto>> addStudent(@RequestBody String name) {
        List<StudentDto> students = studentService.createStudentWithName(name).stream()
            .map(StudentDto.class::cast)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }

    @PutMapping("/{studentId}/students/{courseId}")
    public StudentDto assignStudentToCourse(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        return (StudentDto) studentService.assignStudentToCourse(studentId, courseId);
    }
}
