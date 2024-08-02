package io.spring.modulith.course.persist;

import io.spring.modulith.course.service.Course;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:01:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CourseEntityMapperImpl implements CourseEntityMapper {

    @Override
    public Course getModelFromEntity(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        Course.CourseBuilder course = Course.builder();

        course.id( courseEntity.getId() );
        course.name( courseEntity.getName() );
        course.level( courseEntity.getLevel() );

        return course.build();
    }

    @Override
    public CourseEntity getEntityFromModel(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseEntity.CourseEntityBuilder courseEntity = CourseEntity.builder();

        courseEntity.id( course.getId() );
        courseEntity.name( course.getName() );
        courseEntity.level( course.getLevel() );

        return courseEntity.build();
    }
}
