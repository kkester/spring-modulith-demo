package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseEntity;
import io.spring.modulith.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApplicationRing
@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseDtoMapper courseDtoMapper;

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses().stream()
            .map(courseDtoMapper::courseEntityToCourseDto)
            .toList();
    }

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseDtoMapper.courseEntityToCourseDto(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<List<CourseDto>> addCourse(@RequestBody CourseDto courseDto) {
        CourseEntity courseEntity = courseDtoMapper.courseDtoToCourseEntity(courseDto);
        List<CourseDto> students = courseService.createCourseFrom(courseEntity).stream()
            .map(courseDtoMapper::courseEntityToCourseDto)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }
}
