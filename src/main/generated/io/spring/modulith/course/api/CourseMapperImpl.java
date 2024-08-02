package io.spring.modulith.course.api;

import io.spring.modulith.course.service.Course;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:01:04-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseRecord getRecordFromModel(Course course) {
        if ( course == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Integer level = null;

        id = course.getId();
        name = course.getName();
        level = course.getLevel();

        CourseRecord courseRecord = new CourseRecord( id, name, level );

        return courseRecord;
    }

    @Override
    public Course getModelFromRecord(CourseRecord course) {
        if ( course == null ) {
            return null;
        }

        Course.CourseBuilder course1 = Course.builder();

        course1.id( course.id() );
        course1.name( course.name() );
        course1.level( course.level() );

        return course1.build();
    }
}
