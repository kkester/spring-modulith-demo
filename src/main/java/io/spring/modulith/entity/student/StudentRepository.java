package io.spring.modulith.entity.student;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.data.jpa.repository.JpaRepository;

@Adapter
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
