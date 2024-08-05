package io.spring.modulith.course;

import io.spring.modulith.course.persist.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    public CourseEntity getCourseById(Long id) {
        return courseRepository.findById(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    public List<CourseEntity> createCourseFrom(CourseEntity courseEntity) {
        CourseEntity savedEntity = courseRepository.save(courseEntity);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(savedEntity));
        return getAllCourses();
    }
}
