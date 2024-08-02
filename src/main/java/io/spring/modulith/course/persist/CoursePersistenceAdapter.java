package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.service.CoursePersistPort;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistPort {

    private final CourseRepository repository;
    private final CourseEntityMapper mapper;

    @Override
    public List<CourseRecord> retrieveAll() {
        return repository.findAll().stream()
            .map(mapper::getModelFromEntity)
            .toList();
    }

    @Override
    public Optional<CourseRecord> getCourse(Long id) {
        return repository.findById(id)
            .map(mapper::getModelFromEntity);
    }

    @Override
    public CourseRecord saveCourse(CourseRecord course) {
        CourseEntity courseEntity = mapper.getEntityFromModel(course);
        CourseEntity savedEntity = repository.save(courseEntity);
        return mapper.getModelFromEntity(savedEntity);
    }

    @Override
    public List<CourseRecord> getCourseByStudentId(Long studentId) {
        return repository.findAllByStudentId(studentId);
    }
}
