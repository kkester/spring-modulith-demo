package io.spring.modulith.course.api;

import io.spring.modulith.course.ManageCoursesUseCase;
import io.spring.modulith.course.CourseRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PrimaryAdapter
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final ManageCoursesUseCase manageCoursesUseCase;

    @GetMapping
    public List<CourseRecord> getAllCourses() {
        return manageCoursesUseCase.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseRecord getCourseById(@PathVariable Long id) {
        return manageCoursesUseCase.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<List<CourseRecord>> addCourse(@RequestBody CourseRecord courseRecord) {
        log.info("Received New Course Record {}", courseRecord);
        List<CourseRecord> students = manageCoursesUseCase.createCourseFrom(courseRecord);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
