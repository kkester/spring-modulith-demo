package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseDao;
import io.spring.modulith.course.CourseEntity;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.InfrastructureRing;

import java.util.List;
import java.util.Optional;

@InfrastructureRing
@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseEntity> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<CourseEntity> findCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public CourseEntity save(CourseEntity course) {
        return courseRepository.save(course);
    }
}
