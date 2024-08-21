package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T10:02:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Amazon.com Inc.)"
)
@Component
public class CourseEntityMapperImpl implements CourseEntityMapper {

    @Override
    public CourseRecord getModelFromEntity(CourseEntity courseEntity) {
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
    public CourseEntity getEntityFromModel(CourseRecord course) {
        if ( course == null ) {
            return null;
        }

        CourseEntity.CourseEntityBuilder courseEntity = CourseEntity.builder();

        courseEntity.id( course.id() );
        courseEntity.name( course.name() );
        courseEntity.level( course.level() );

        return courseEntity.build();
    }
}
