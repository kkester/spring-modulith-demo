package io.spring.modulith.student.persist;

import io.spring.modulith.student.StudentRecord;
import io.spring.modulith.student.service.StudentPersistPort;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistPort {

    private final StudentRepository repository;
    private final StudentEntityMapper mapper;

    @Override
    public List<StudentRecord> retrieveAll() {
        return repository.findAll().stream()
            .map(mapper::getModelFromEntity)
            .toList();
    }

    @Override
    public Optional<StudentRecord> getStudent(Long id) {
        return repository.findById(id)
            .map(mapper::getModelFromEntity);
    }

    @Override
    public StudentRecord saveStudent(StudentRecord student) {
        StudentEntity studentEntity = mapper.getEntityFromModel(student);
        StudentEntity savedEntity = repository.save(studentEntity);
        return mapper.getModelFromEntity(savedEntity);
    }
}
