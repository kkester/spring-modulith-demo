package io.spring.modulith.student;

import java.util.List;

public record StudentCoursesRecord(Long id, String name, List<CourseRecord> courses) {
}
