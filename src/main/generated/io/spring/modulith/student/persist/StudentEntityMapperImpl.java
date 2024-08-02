package io.spring.modulith.student.persist;

import io.spring.modulith.student.service.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:01:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StudentEntityMapperImpl implements StudentEntityMapper {

    @Override
    public Student getModelFromEntity(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.id( studentEntity.getId() );
        student.name( studentEntity.getName() );

        return student.build();
    }

    @Override
    public StudentEntity getEntityFromModel(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity.StudentEntityBuilder studentEntity = StudentEntity.builder();

        studentEntity.id( student.getId() );
        studentEntity.name( student.getName() );

        return studentEntity.build();
    }
}
