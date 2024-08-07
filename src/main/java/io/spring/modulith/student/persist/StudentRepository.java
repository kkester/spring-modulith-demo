package io.spring.modulith.student.persist;

import io.spring.modulith.student.StudentEntity;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.data.jpa.repository.JpaRepository;

@InfrastructureRing
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
