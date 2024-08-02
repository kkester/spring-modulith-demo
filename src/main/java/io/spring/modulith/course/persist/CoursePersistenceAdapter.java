package io.spring.modulith.course.persist;

import io.spring.modulith.course.service.Course;
import io.spring.modulith.course.service.CoursePersistPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistPort {

    private final CourseRepository repository;
    private final CourseEntityMapper mapper;

    @Override
    public List<Course> retrieveAll() {
        return repository.findAll().stream()
            .map(mapper::getModelFromEntity)
            .toList();
    }

    @Override
    public Optional<Course> getCourse(Long id) {
        return repository.findById(id)
            .map(mapper::getModelFromEntity);
    }

    @Override
    public Course saveCourse(Course student) {
        CourseEntity studentEntity = mapper.getEntityFromModel(student);
        CourseEntity savedEntity = repository.save(studentEntity);
        return mapper.getModelFromEntity(savedEntity);
    }
}
