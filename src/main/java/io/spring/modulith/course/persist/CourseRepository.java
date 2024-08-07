package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseEntity;
import org.jmolecules.architecture.onion.simplified.InfrastructureRing;
import org.springframework.data.jpa.repository.JpaRepository;

@InfrastructureRing
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
