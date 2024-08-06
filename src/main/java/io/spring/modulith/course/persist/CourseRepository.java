package io.spring.modulith.course.persist;

import org.jmolecules.architecture.layered.InfrastructureLayer;
import org.springframework.data.jpa.repository.JpaRepository;

@InfrastructureLayer
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
