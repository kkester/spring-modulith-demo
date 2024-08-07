package io.spring.modulith.student;

import org.jmolecules.architecture.onion.classical.DomainModelRing;

import java.util.List;
import java.util.Optional;

@DomainModelRing
public interface StudentDao {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student studentRecord);
    Student newStudent();
}
