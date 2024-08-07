package io.spring.modulith.course;

import io.spring.modulith.course.event.CourseCreatedEvent;
import io.spring.modulith.course.persist.CourseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.classical.DomainServiceRing;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@DomainServiceRing
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseDao courseDao;
    private final ApplicationEventPublisher applicationEventPublisher;

    public List<Course> getAllCourses() {
        return courseDao.findAllCourses();
    }

    public Course getCourseById(Long id) {
        return courseDao.findCourseById(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    public List<Course> createCourseFrom(Course course) {
        Course savedCourse = courseDao.save(course);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(savedCourse));
        return getAllCourses();
    }
}
