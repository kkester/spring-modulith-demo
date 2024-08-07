package io.spring.modulith.student.api.mapper;

import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.api.StudentDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T13:30:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StudentDtoMapperImpl implements StudentDtoMapper {

    @Override
    public StudentDto studentEntityToStudentDto(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( studentEntity.getId() );
        studentDto.setName( studentEntity.getName() );

        return studentDto;
    }
}
