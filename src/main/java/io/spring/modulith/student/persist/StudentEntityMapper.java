package io.spring.modulith.student.persist;

import io.spring.modulith.entity.student.StudentEntity;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentEntityMapper {
    StudentRecord studentRecordToStudentEntity(StudentEntity studentEntity);
    StudentCoursesRecord studentCoursesRecordToStudentEntity(StudentEntity studentEntity);
    StudentEntity studentEntityToStudentRecord(StudentRecord student);
}
