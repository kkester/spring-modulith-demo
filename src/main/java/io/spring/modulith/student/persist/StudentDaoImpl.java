package io.spring.modulith.student.persist;

import io.spring.modulith.student.StudentDao;
import io.spring.modulith.student.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.onion.simplified.InfrastructureRing;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@InfrastructureRing
@Component
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private final StudentRepository studentRepository;

    @Override
    public Optional<StudentEntity> findById(Long id) {
        return studentRepository.findById(id)
            .map(StudentEntity.class::cast);
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }
}
