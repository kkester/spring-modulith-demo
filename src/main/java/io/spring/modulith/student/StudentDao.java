package io.spring.modulith.student;

import org.jmolecules.architecture.onion.simplified.DomainRing;

import java.util.List;
import java.util.Optional;

@DomainRing
public interface StudentDao {
    Optional<StudentEntity> findById(Long id);
    List<StudentEntity> findAll();
    StudentEntity save(StudentEntity studentRecord);
}
