package io.spring.modulith.course;

import org.jmolecules.architecture.onion.classical.DomainModelRing;

import java.util.List;
import java.util.Optional;

@DomainModelRing
public interface CourseDao {
    List<CourseEntity> findAllCourses();
    Optional<CourseEntity> findCourseById(Long id);
    CourseEntity save(CourseEntity course);
}
