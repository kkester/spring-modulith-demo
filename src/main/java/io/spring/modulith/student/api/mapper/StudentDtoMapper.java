package io.spring.modulith.student.api.mapper;

import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.api.StudentDto;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@ApplicationRing
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface StudentDtoMapper {
    StudentDto studentEntityToStudentDto(StudentEntity studentEntity);
}
