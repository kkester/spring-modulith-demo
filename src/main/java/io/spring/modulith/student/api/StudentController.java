package io.spring.modulith.student.api;

import io.spring.modulith.course.ManageCoursesUseCase;
import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.ManageStudentsUseCase;
import io.spring.modulith.student.StudentRecord;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PrimaryAdapter
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final ManageStudentsUseCase manageStudentsUseCase;
    private final ManageCoursesUseCase manageCoursesUseCase;

    @GetMapping
    public List<StudentRecord> getAllStudents() {
        return manageStudentsUseCase.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentCoursesRecord getStudentById(@PathVariable Long id) {
        StudentRecord student = manageStudentsUseCase.getStudentById(id);
        List<CourseRecord> courses = manageCoursesUseCase.getCourseByStudentId(id);
        return new StudentCoursesRecord(student.id(), student.name(), courses);
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<StudentRecord>> addStudent(@RequestBody String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is blank!");
        }
        List<StudentRecord> students = manageStudentsUseCase.createStudentWithName(name);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
