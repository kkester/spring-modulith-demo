package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseModelPort;
import io.spring.modulith.course.service.Course;
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
    private final CourseMapper mapper;

    @GetMapping
    public List<CourseRecord> getAllCourses() {
        return courseModelPort.getAllCourses().stream()
            .map(mapper::getRecordFromModel)
            .toList();
    }

    @GetMapping("/{id}")
    public CourseRecord getCourseById(@PathVariable Long id) {
        Course student = courseModelPort.getCourseById(id);
        return mapper.getRecordFromModel(student);
    }

    @PostMapping
    public ResponseEntity<List<CourseRecord>> addCourse(@RequestBody CourseRecord courseRecord) {
        List<CourseRecord> students = courseModelPort.createCourseFrom(mapper.getModelFromRecord(courseRecord)).stream()
            .map(mapper::getRecordFromModel)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
