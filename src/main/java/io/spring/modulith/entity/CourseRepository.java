package io.spring.modulith.entity;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
