package io.spring.modulith.student.api;

import io.spring.modulith.student.StudentEntity;
import io.spring.modulith.student.api.StudentRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentEntityMapper {
    StudentRecord getModelFromEntity(StudentEntity studentEntity);
    StudentEntity getEntityFromModel(StudentRecord student);
}
