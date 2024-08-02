package io.spring.modulith.course.api;

import io.spring.modulith.course.service.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
    CourseRecord getRecordFromModel(Course course);
    Course getModelFromRecord(CourseRecord course);
}
