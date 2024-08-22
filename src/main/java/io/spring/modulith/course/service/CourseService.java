package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.ManageCoursesUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Application
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService implements ManageCoursesUseCase {

    private final CoursePersistPort coursePersistPort;
    private final CourseNotificationPort courseNotificationPort;

    @Override
    public List<CourseRecord> getAllCourses() {
        return coursePersistPort.retrieveAll();
    }

    @Override
    public CourseRecord getCourseById(Long id) {
        return coursePersistPort.getCourse(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    @Transactional
    @Override
    public List<CourseRecord> createCourseFrom(CourseRecord course) {
        CourseRecord savedCourse = coursePersistPort.saveCourse(course);
        courseNotificationPort.notifyCourseCreated(savedCourse);
        return coursePersistPort.retrieveAll();
    }

    @Override
    public List<CourseRecord> getCourseByStudentId(Long studentId) {
        return coursePersistPort.getCourseByStudentId(studentId);
    }

    @Override
    public List<CourseRecord> assignStudentToCourse(Long courseId, Long studentId) {
        log.info("Assigning student {} to course {}", studentId, courseId);
        coursePersistPort.assignStudentToCourse(courseId,studentId);
        return getCourseByStudentId(studentId);
    }

    @Override
    public void selectCoursesForStudent(Long studentId) {
        Random random = new Random();
        coursePersistPort.retrieveAll().stream()
            .filter(courseRecord -> random.nextInt(100) > 60)
            .forEach(courseRecord -> assignStudentToCourse(courseRecord.id(), studentId));
    }
}
