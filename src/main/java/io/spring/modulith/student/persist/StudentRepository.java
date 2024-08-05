package io.spring.modulith.student.persist;

import io.spring.modulith.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
