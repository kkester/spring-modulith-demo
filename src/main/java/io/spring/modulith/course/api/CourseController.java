package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseModelPort;
import io.spring.modulith.course.CourseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseModelPort courseModelPort;

    @GetMapping
    public List<CourseRecord> getAllCourses() {
        return courseModelPort.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseRecord getCourseById(@PathVariable Long id) {
        return courseModelPort.getCourseById(id);
    }

    @PostMapping
    public ResponseEntity<List<CourseRecord>> addCourse(@RequestBody CourseRecord courseRecord) {
        List<CourseRecord> students = courseModelPort.createCourseFrom(courseRecord);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
