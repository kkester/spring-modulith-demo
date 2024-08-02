package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseCreatedEvent;
import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.ManageCoursesUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Application
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService implements ManageCoursesUseCase {

    private final CoursePersistPort coursePersistPort;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public List<CourseRecord> getAllCourses() {
        return coursePersistPort.retrieveAll();
    }

    @Override
    public CourseRecord getCourseById(Long id) {
        return coursePersistPort.getCourse(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public List<CourseRecord> createCourseFrom(CourseRecord course) {
        CourseRecord savedCourse = coursePersistPort.saveCourse(course);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(savedCourse));
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
}
