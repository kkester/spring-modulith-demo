package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.layered.InterfaceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@InterfaceLayer
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseRecord> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseRecord getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<List<CourseRecord>> addCourse(@RequestBody CourseRecord courseRecord) {
        List<CourseRecord> students = courseService.createCourseFrom(courseRecord);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
