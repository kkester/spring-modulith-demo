package io.spring.modulith.student.persist;

import io.spring.modulith.student.StudentRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentEntityMapper {
    StudentRecord getModelFromEntity(StudentEntity studentEntity);
    StudentEntity getEntityFromModel(StudentRecord student);
}
