package io.spring.modulith.student.api;

import io.spring.modulith.course.CourseEntity;
import io.spring.modulith.course.api.CourseDto;
import io.spring.modulith.student.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T13:07:35-0500",
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
        studentDto.setCourses( courseEntityListToCourseDtoList( studentEntity.getCourses() ) );

        return studentDto;
    }

    protected CourseDto courseEntityToCourseDto(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( courseEntity.getId() );
        courseDto.setName( courseEntity.getName() );
        courseDto.setLevel( courseEntity.getLevel() );

        return courseDto;
    }

    protected List<CourseDto> courseEntityListToCourseDtoList(List<CourseEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseDto> list1 = new ArrayList<CourseDto>( list.size() );
        for ( CourseEntity courseEntity : list ) {
            list1.add( courseEntityToCourseDto( courseEntity ) );
        }

        return list1;
    }
}
