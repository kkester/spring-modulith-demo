package io.spring.modulith.course.api;

import io.spring.modulith.course.Course;
import io.spring.modulith.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.ApplicationServiceRing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApplicationServiceRing
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<List<Course>> addCourse(@RequestBody Course courseRecord) {
        List<Course> students = courseService.createCourseFrom(courseRecord);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
