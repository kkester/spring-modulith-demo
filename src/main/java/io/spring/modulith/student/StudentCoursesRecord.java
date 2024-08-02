package io.spring.modulith.student;

import io.spring.modulith.course.CourseRecord;

import java.util.List;

public record StudentCoursesRecord(Long id, String name, List<CourseRecord> courses) {
}
