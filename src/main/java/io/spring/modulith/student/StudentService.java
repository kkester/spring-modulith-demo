package io.spring.modulith.student;

import io.spring.modulith.course.CourseEntity;
import io.spring.modulith.course.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@DomainRing
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final CourseService courseService;
    private final StudentDao studentDao;

    public StudentEntity getStudentById(Long id) {
        return studentDao.findById(id)
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<StudentEntity> getAllStudents() {
        return studentDao.findAll();
    }

    public List<StudentEntity> createStudentWithName(String name) {
        StudentEntity student = new StudentEntity();
        student.setName(name);
        studentDao.save(student);
        return getAllStudents();
    }

    public StudentEntity assignStudentToCourse(Long studentId, Long courseId) {
        log.info("Assigning course {} to student {}", courseId, studentId);
        StudentEntity student = studentDao.findById(studentId)
            .orElseThrow(StudentNotFoundException::new);
        CourseEntity course = courseService.getCourseEntityById(courseId);
        student.addCourse(course);
        return studentDao.save(student);
    }

    public void selectStudentsForCourse(Long courseId) {
        Random random = new Random();
        studentDao.findAll().stream()
            .filter(student -> random.nextInt(100) > 60)
            .forEach(student -> assignStudentToCourse(student.getId(), courseId));
    }
}
