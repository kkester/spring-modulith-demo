package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.entity.CourseEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-07T15:34:26-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CourseEntityMapperImpl implements CourseEntityMapper {

    @Override
    public CourseRecord courseEntityToCourseRecord(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Integer level = null;

        id = courseEntity.getId();
        name = courseEntity.getName();
        level = courseEntity.getLevel();

        CourseRecord courseRecord = new CourseRecord( id, name, level );

        return courseRecord;
    }

    @Override
    public CourseEntity courseRecordToCourseEntity(CourseRecord course) {
        if ( course == null ) {
            return null;
        }

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId( course.id() );
        courseEntity.setName( course.name() );
        courseEntity.setLevel( course.level() );

        return courseEntity;
    }
}
