package io.spring.modulith.student.api;

import java.util.List;

public record StudentCoursesRecord(Long id, String name, List<Object> courses) {
}
