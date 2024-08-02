package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseEntityMapper {
    CourseRecord getModelFromEntity(CourseEntity courseEntity);
    CourseEntity getEntityFromModel(CourseRecord course);
}
