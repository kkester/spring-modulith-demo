package io.spring.modulith.course;

import io.spring.modulith.course.event.CourseCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.onion.simplified.DomainRing;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@DomainRing
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseDao courseDao;
    private final ApplicationEventPublisher applicationEventPublisher;

    public List<CourseEntity> getAllCourses() {
        return courseDao.findAllCourses();
    }

    public CourseEntity getCourseById(Long id) {
        return courseDao.findCourseById(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    public List<CourseEntity> createCourseFrom(CourseEntity courseEntity) {
        CourseEntity savedCourse = courseDao.save(courseEntity);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(savedCourse));
        return getAllCourses();
    }

    public CourseEntity getCourseEntityById(Long courseId) {
        return courseDao.findCourseById(courseId)
            .orElseThrow(CourseNotFoundException::new);
    }
}
