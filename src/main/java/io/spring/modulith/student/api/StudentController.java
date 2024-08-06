package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import io.spring.modulith.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.layered.InterfaceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@InterfaceLayer
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentRecord> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentCoursesRecord getStudentById(@PathVariable(value = "id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<StudentRecord>> addStudent(@RequestBody String name) {
        List<StudentRecord> students = studentService.createStudentWithName(name);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }

    @PutMapping("/{studentId}/students/{courseId}")
    public StudentCoursesRecord assignStudentToCourse(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        return studentService.assignStudentToCourse(studentId, courseId);
    }
}
