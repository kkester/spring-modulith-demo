package io.spring.modulith.student.persist;

import io.spring.modulith.student.service.StudentPersistPort;
import io.spring.modulith.student.service.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistPort {

    private final StudentRepository repository;
    private final StudentEntityMapper mapper;

    @Override
    public List<Student> retrieveAll() {
        return repository.findAll().stream()
            .map(mapper::getModelFromEntity)
            .toList();
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return repository.findById(id)
            .map(mapper::getModelFromEntity);
    }

    @Override
    public Student saveStudent(Student student) {
        StudentEntity studentEntity = mapper.getEntityFromModel(student);
        StudentEntity savedEntity = repository.save(studentEntity);
        return mapper.getModelFromEntity(savedEntity);
    }
}
