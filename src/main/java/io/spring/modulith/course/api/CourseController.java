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
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses().stream()
            .map(CourseDto.class::cast)
            .toList();
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return (CourseDto)courseService.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<List<CourseDto>> addCourse(@RequestBody CourseDto courseRecord) {
        List<CourseDto> courses = courseService.createCourseFrom(courseRecord).stream()
            .map(CourseDto.class::cast)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(courses);
    }
}
