package io.spring.modulith.student;

import io.spring.modulith.course.CourseService;
import io.spring.modulith.course.persist.CourseEntity;
import io.spring.modulith.student.persist.StudentEntity;
import io.spring.modulith.student.persist.StudentEntityMapper;
import io.spring.modulith.student.persist.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.layered.ApplicationLayer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@ApplicationLayer
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final CourseService courseService;
    private final StudentEntityMapper studentEntityMapper;
    private final StudentRepository studentRepository;

    public StudentCoursesRecord getStudentById(Long id) {
        return studentRepository.findById(id)
            .map(studentEntityMapper::studentEntityToStudentCoursesRecord)
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<StudentRecord> getAllStudents() {
        return studentRepository.findAll().stream()
            .map(studentEntityMapper::getRecordFromEntity)
            .toList();
    }

    public List<StudentRecord> createStudentWithName(String name) {
        StudentEntity studentEntity = new StudentEntity(null, name, Collections.emptyList());
        studentRepository.save(studentEntity);
        return getAllStudents();
    }

    @Transactional
    public StudentCoursesRecord assignStudentToCourse(Long studentId, Long courseId) {
        log.info("Assigning course {} to student {}", courseId, studentId);
        StudentEntity studentEntity = studentRepository.findById(studentId)
            .orElseThrow(StudentNotFoundException::new);
        CourseEntity courseEntity = courseService.getCourseEntityById(courseId);
        studentEntity.addCourse(courseEntity);
        studentRepository.save(studentEntity);
        return studentEntityMapper.studentEntityToStudentCoursesRecord(studentEntity);
    }

    public void selectStudentsForCourse(Long courseId) {
        Random random = new Random();
        studentRepository.findAll().stream()
            .filter(student -> random.nextInt(100) > 60)
            .forEach(student -> assignStudentToCourse(student.getId(), courseId));
    }
}
