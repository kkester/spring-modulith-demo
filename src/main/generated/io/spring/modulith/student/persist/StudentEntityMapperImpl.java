package io.spring.modulith.student.persist;

import io.spring.modulith.student.StudentRecord;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T11:40:14-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StudentEntityMapperImpl implements StudentEntityMapper {

    @Override
    public StudentRecord getModelFromEntity(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = studentEntity.getId();
        name = studentEntity.getName();

        StudentRecord studentRecord = new StudentRecord( id, name );

        return studentRecord;
    }

    @Override
    public StudentEntity getEntityFromModel(StudentRecord student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity.StudentEntityBuilder studentEntity = StudentEntity.builder();

        studentEntity.id( student.id() );
        studentEntity.name( student.name() );

        return studentEntity.build();
    }
}
