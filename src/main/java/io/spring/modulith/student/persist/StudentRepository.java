package io.spring.modulith.student.persist;

import org.jmolecules.architecture.layered.InfrastructureLayer;
import org.springframework.data.jpa.repository.JpaRepository;

@InfrastructureLayer
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
