package io.spring.modulith.course;

import io.spring.modulith.course.persist.CourseEntity;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

import java.util.List;
import java.util.Optional;

@DomainModelRing
public interface CourseDao {
    List<Course> findAllCourses();
    Optional<Course> findCourseById(Long id);
    Course save(Course course);
}
