package io.spring.modulith.course.persist;

import io.spring.modulith.course.service.Course;
import io.spring.modulith.student.service.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseEntityMapper {
    Course getModelFromEntity(CourseEntity courseEntity);
    CourseEntity getEntityFromModel(Course course);
}
