package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseEntity;
import io.spring.modulith.course.CourseService;
import io.spring.modulith.course.persist.CourseEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseEntityMapper courseEntityMapper;

    @GetMapping
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseRecord getCourseById(@PathVariable Long id) {
        return courseEntityMapper.getModelFromEntity(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<List<CourseRecord>> addCourse(@RequestBody CourseRecord courseRecord) {
        CourseEntity courseEntity = courseEntityMapper.getEntityFromModel(courseRecord);
        List<CourseRecord> students = courseService.createCourseFrom(courseEntity).stream()
            .map(courseEntityMapper::getModelFromEntity)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
