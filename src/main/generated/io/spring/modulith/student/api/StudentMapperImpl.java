package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentRecord;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:20:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentRecord getRecordFromModel(Student student) {
        if ( student == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = student.getId();
        name = student.getName();

        StudentRecord studentRecord = new StudentRecord( id, name );

        return studentRecord;
    }
}
