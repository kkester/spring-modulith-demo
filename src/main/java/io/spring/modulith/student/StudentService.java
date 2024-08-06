package io.spring.modulith.student;

import io.spring.modulith.course.CourseService;
import io.spring.modulith.course.persist.CourseEntity;
import io.spring.modulith.student.persist.StudentEntity;
import io.spring.modulith.student.persist.StudentEntityMapper;
import io.spring.modulith.student.persist.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.layered.ApplicationLayer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@ApplicationLayer
@Service
@RequiredArgsConstructor
public class StudentService {

    private final CourseService courseService;
    private final StudentEntityMapper studentEntityMapper;
    private final StudentRepository studentRepository;

    public StudentCoursesRecord getStudentById(Long id) {
        return studentRepository.findById(id)
            .map(studentEntity -> new StudentCoursesRecord(studentEntity.getId(), studentEntity.getName(), Collections.emptyList()))
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<StudentRecord> getAllStudents() {
        return studentRepository.findAll().stream()
            .map(studentEntityMapper::getModelFromEntity)
            .toList();
    }

    public List<StudentRecord> createStudentWithName(String name) {
        StudentEntity studentEntity = new StudentEntity(null, name, Collections.emptyList());
        studentRepository.save(studentEntity);
        return getAllStudents();
    }

    public StudentCoursesRecord assignStudentToCourse(Long studentId, Long courseId) {
        StudentEntity studentEntity = studentRepository.findById(studentId)
            .orElseThrow(StudentNotFoundException::new);
//        CourseEntity courseEntity = courseService.getCourseById(courseId);
//        studentEntity.addCourse(courseEntity);
        return new StudentCoursesRecord(studentEntity.getId(), studentEntity.getName(), Collections.emptyList());
    }

    public void selectStudentsForCourse(Long courseId) {
        Random random = new Random();
        studentRepository.findAll().stream()
            .filter(student -> random.nextInt(100) > 60)
            .forEach(student -> assignStudentToCourse(courseId, student.getId()));
    }
}
