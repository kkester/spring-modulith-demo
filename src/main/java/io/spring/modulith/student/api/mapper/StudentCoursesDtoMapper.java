package io.spring.modulith.student.api.mapper;

import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.api.StudentCoursesDto;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@ApplicationRing
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface StudentCoursesDtoMapper {
    StudentCoursesDto studentEntityToStudentDto(StudentEntity studentEntity);
}
