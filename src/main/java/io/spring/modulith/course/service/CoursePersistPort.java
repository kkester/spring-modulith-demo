package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseRecord;

import java.util.List;
import java.util.Optional;

public interface CoursePersistPort {
    List<CourseRecord> retrieveAll();
    Optional<CourseRecord> getCourse(Long id);
    CourseRecord saveCourse(CourseRecord student);
    List<CourseRecord> getCourseByStudentId(Long studentId);
}
