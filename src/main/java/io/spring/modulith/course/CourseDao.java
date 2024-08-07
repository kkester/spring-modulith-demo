package io.spring.modulith.course;

import org.jmolecules.architecture.onion.classical.DomainModelRing;

import java.util.List;
import java.util.Optional;

@DomainModelRing
public interface CourseDao {
    Course newCourse();
    List<Course> findAllCourses();
    Optional<Course> findCourseById(Long id);
    Course save(Course course);
}
