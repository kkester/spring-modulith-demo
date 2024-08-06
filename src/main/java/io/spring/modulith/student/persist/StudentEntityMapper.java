package io.spring.modulith.student.persist;

import io.spring.modulith.course.persist.CourseEntity;
import io.spring.modulith.student.CourseRecord;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentEntityMapper {
    StudentRecord getRecordFromEntity(StudentEntity studentEntity);
    StudentCoursesRecord studentEntityToStudentCoursesRecord(StudentEntity studentEntity);
    StudentEntity getEntityFromRecord(StudentRecord student);
    CourseRecord courseEntityToCourseRecord(CourseEntity courseEntity);
}
