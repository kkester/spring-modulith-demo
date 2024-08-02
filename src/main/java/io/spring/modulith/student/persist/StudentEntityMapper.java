package io.spring.modulith.student.persist;

import io.spring.modulith.student.service.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentEntityMapper {
    Student getModelFromEntity(StudentEntity studentEntity);
    StudentEntity getEntityFromModel(Student student);
}
