package io.spring.modulith.student.persist;

import io.spring.modulith.entity.StudentEntity;
import io.spring.modulith.entity.StudentRepository;
import io.spring.modulith.student.StudentCoursesRecord;
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
            .map(mapper::studentRecordToStudentEntity)
            .toList();
    }

    @Override
    public Optional<StudentCoursesRecord> getStudent(Long id) {
        return repository.findById(id)
            .map(mapper::studentCoursesRecordToStudentEntity);
    }

    @Override
    public StudentRecord saveStudent(StudentRecord student) {
        StudentEntity studentEntity = mapper.studentEntityToStudentRecord(student);
        StudentEntity savedEntity = repository.save(studentEntity);
        return mapper.studentRecordToStudentEntity(savedEntity);
    }
}
