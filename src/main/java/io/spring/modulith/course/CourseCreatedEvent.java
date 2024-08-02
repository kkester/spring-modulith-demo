package io.spring.modulith.course;

import org.springframework.context.ApplicationEvent;

public class CourseCreatedEvent extends ApplicationEvent {

    private final Long courseId;

    public CourseCreatedEvent(CourseRecord source) {
        super(source);
        this.courseId = source.id();
    }

    public Long getCourseRecordId() {
        return courseId;
    }
}
