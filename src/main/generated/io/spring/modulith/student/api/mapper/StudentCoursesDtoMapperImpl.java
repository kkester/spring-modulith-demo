package io.spring.modulith.student.api.mapper;

import io.spring.modulith.course.CourseEntity;
import io.spring.modulith.course.api.CourseDto;
import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.api.StudentCoursesDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T13:30:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StudentCoursesDtoMapperImpl implements StudentCoursesDtoMapper {

    @Override
    public StudentCoursesDto studentEntityToStudentDto(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentCoursesDto studentCoursesDto = new StudentCoursesDto();

        studentCoursesDto.setId( studentEntity.getId() );
        studentCoursesDto.setName( studentEntity.getName() );
        studentCoursesDto.setCourses( courseEntityListToCourseDtoList( studentEntity.getCourses() ) );

        return studentCoursesDto;
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
