package io.spring.modulith.course.api;

public record CourseRecord(Long id, String name, Integer level) {
    public CourseRecord {
        if (level < 100 || level > 499) {
            throw new IllegalArgumentException("'level' must be between 100 and 499");
        }
    }
}
