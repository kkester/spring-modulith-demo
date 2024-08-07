package io.spring.modulith.course.persist;

import io.spring.modulith.course.Course;
import io.spring.modulith.course.CourseDao;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import java.util.List;
import java.util.Optional;

@InfrastructureRing
public class CourseDaoImpl implements CourseDao {
    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public Optional<Course> findCourseById(Long id) {
        return Optional.empty();
    }

    @Override
    public CourseEntity save(Course courseRecord) {
        return null;
    }
}
