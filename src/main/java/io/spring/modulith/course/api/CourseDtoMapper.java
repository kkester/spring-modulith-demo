package io.spring.modulith.course.api;

import io.spring.modulith.course.CourseEntity;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@ApplicationRing
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface CourseDtoMapper {
    CourseDto courseEntityToCourseDto(CourseEntity courseEntity);
    CourseEntity courseDtoToCourseEntity(CourseDto courseRecord);
}
