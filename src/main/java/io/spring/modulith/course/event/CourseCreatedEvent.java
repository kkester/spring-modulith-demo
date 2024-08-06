package io.spring.modulith.course.event;

import io.spring.modulith.course.persist.CourseEntity;
import org.springframework.context.ApplicationEvent;

public class CourseCreatedEvent extends ApplicationEvent {

    private final Long courseId;

    public CourseCreatedEvent(CourseEntity source) {
        super(source);
        this.courseId = source.getId();
    }

    public Long getCourseRecordId() {
        return courseId;
    }
}
