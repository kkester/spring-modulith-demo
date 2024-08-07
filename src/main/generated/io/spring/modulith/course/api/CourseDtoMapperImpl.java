package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T13:04:02-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CourseDtoMapperImpl implements CourseDtoMapper {

    @Override
    public CourseDto courseEntityToCourseDto(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( courseEntity.getId() );
        courseDto.setName( courseEntity.getName() );
        courseDto.setLevel( courseEntity.getLevel() );

        return courseDto;
    }

    @Override
    public CourseEntity courseDtoToCourseEntity(CourseDto courseRecord) {
        if ( courseRecord == null ) {
            return null;
        }

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId( courseRecord.getId() );
        courseEntity.setName( courseRecord.getName() );
        courseEntity.setLevel( courseRecord.getLevel() );

        return courseEntity;
    }
}
