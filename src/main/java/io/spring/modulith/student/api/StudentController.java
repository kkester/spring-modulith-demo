package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.StudentService;
import io.spring.modulith.student.api.mapper.StudentCoursesDtoMapper;
import io.spring.modulith.student.api.mapper.StudentDtoMapper;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApplicationRing
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentDtoMapper studentDtoMapper;
    private final StudentCoursesDtoMapper studentCoursesDtoMapper;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents().stream()
            .map(studentDtoMapper::studentEntityToStudentDto)
            .toList();
    }

    @GetMapping("/{id}")
    public StudentCoursesDto getStudentById(@PathVariable(value = "id") Long id) {
        return studentCoursesDtoMapper.studentEntityToStudentDto(studentService.getStudentById(id));
    }

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<List<StudentDto>> addStudent(@RequestBody String name) {
        List<StudentDto> students = studentService.createStudentWithName(name).stream()
            .map(studentDtoMapper::studentEntityToStudentDto)
            .toList();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(students);
    }

    @PutMapping("/{studentId}/students/{courseId}")
    public StudentCoursesDto assignStudentToCourse(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) {
        StudentEntity studentEntity = studentService.assignStudentToCourse(studentId, courseId);
        return studentCoursesDtoMapper.studentEntityToStudentDto(studentEntity);
    }
}
