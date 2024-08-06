package io.spring.modulith.course;

import io.spring.modulith.course.event.CourseCreatedEvent;
import io.spring.modulith.course.persist.CourseEntity;
import io.spring.modulith.course.persist.CourseEntityMapper;
import io.spring.modulith.course.persist.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.layered.ApplicationLayer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@ApplicationLayer
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CourseEntityMapper courseEntityMapper;

    public List<CourseRecord> getAllCourses() {
        return courseRepository.findAll().stream()
            .map(courseEntityMapper::getModelFromEntity)
            .toList();
    }

    public CourseRecord getCourseById(Long id) {
        return courseRepository.findById(id)
            .map(courseEntityMapper::getModelFromEntity)
            .orElseThrow(CourseNotFoundException::new);
    }

    public List<CourseRecord> createCourseFrom(CourseRecord courseRecord) {
        CourseEntity courseEntity = courseEntityMapper.getEntityFromModel(courseRecord);
        CourseEntity savedEntity = courseRepository.save(courseEntity);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(savedEntity));
        return getAllCourses();
    }
}
