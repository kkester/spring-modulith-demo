package io.spring.modulith.course.persist;

import io.spring.modulith.course.Course;
import io.spring.modulith.course.CourseDao;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@InfrastructureRing
@Component
@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final CourseRepository courseRepository;

    @Override
    public Course newCourse() {
        return new CourseEntity();
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll().stream()
            .map(Course.class::cast)
            .toList();
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        return courseRepository.findById(id)
            .map(Course.class::cast);
    }

    @Override
    public CourseEntity save(Course course) {
        return courseRepository.save((CourseEntity) course);
    }
}
