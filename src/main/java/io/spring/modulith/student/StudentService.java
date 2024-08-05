package io.spring.modulith.student;

import io.spring.modulith.course.CourseEntity;
import io.spring.modulith.course.CourseService;
import io.spring.modulith.student.persist.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseService courseService;
    private final StudentRepository studentRepository;

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentEntity> createStudentWithName(String name) {
        StudentEntity studentEntity = new StudentEntity(null, name, Collections.emptyList());
        studentRepository.save(studentEntity);
        return getAllStudents();
    }

    public StudentEntity assignStudentToCourse(Long studentId, Long courseId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
            .orElseThrow(StudentNotFoundException::new);
        CourseEntity courseEntity = courseService.getCourseById(courseId);
        studentEntity.addCourse(courseEntity);
        return studentEntity;
    }

    public void selectStudentsForCourse(Long courseId) {
        Random random = new Random();
        studentRepository.findAll().stream()
            .filter(student -> random.nextInt(100) > 60)
            .forEach(student -> assignStudentToCourse(courseId, student.getId()));
    }
}
