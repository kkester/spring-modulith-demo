package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.entity.course.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseEntityMapper {
    CourseRecord courseEntityToCourseRecord(CourseEntity courseEntity);
    CourseEntity courseRecordToCourseEntity(CourseRecord course);
}
