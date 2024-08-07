package io.spring.modulith.student.persist;

import io.spring.modulith.student.Student;
import io.spring.modulith.student.StudentDao;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@InfrastructureRing
@Component
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private final StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id)
            .map(Student.class::cast);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll().stream()
            .map(Student.class::cast)
            .toList();
    }

    @Override
    public StudentEntity save(Student student) {
        return studentRepository.save((StudentEntity) student);
    }

    @Override
    public Student newStudent() {
        return new StudentEntity();
    }
}
