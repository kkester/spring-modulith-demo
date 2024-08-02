package io.spring.modulith.student.api;

import io.spring.modulith.student.service.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    StudentRecord getRecordFromModel(Student student);
}
