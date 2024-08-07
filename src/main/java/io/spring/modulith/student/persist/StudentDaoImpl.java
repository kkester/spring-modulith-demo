package io.spring.modulith.student.persist;

import io.spring.modulith.student.Student;
import io.spring.modulith.student.StudentDao;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import java.util.List;
import java.util.Optional;

@InfrastructureRing
public class StudentDaoImpl implements StudentDao {
    @Override
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student save(Student studentRecord) {
        return null;
    }

    @Override
    public Student newStudent() {
        return null;
    }
}
