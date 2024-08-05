package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
