package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentEntity;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@ApplicationRing
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentDtoMapper {
    StudentDto studentEntityToStudentDto(StudentEntity studentEntity);
}
