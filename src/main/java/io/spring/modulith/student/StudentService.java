package io.spring.modulith.student;

import io.spring.modulith.course.Course;
import io.spring.modulith.course.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.classical.DomainServiceRing;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@DomainServiceRing
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final CourseService courseService;
    private final StudentDao studentDao;

    public Student getStudentById(Long id) {
        return studentDao.findById(id)
            .orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public List<Student> createStudentWithName(String name) {
        Student student = studentDao.newStudent();
        student.setName(name);
        studentDao.save(student);
        return getAllStudents();
    }

    @Transactional
    public Student assignStudentToCourse(Long studentId, Long courseId) {
        log.info("Assigning course {} to student {}", courseId, studentId);
        AddCourseToStudentAction student = studentDao.findById(studentId)
            .map(AddCourseToStudentAction.class::cast)
            .orElseThrow(StudentNotFoundException::new);
        Course course = courseService.getCourseById(courseId);
        student.addCourse(course);
        return studentDao.save((Student) student);
    }

    public void selectStudentsForCourse(Long courseId) {
        Random random = new Random();
        studentDao.findAll().stream()
            .filter(student -> random.nextInt(100) > 60)
            .forEach(student -> assignStudentToCourse(student.getId(), courseId));
    }
}
