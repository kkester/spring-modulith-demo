package io.spring.modulith.course;

import org.jmolecules.event.annotation.DomainEvent;
import org.springframework.context.ApplicationEvent;

@DomainEvent
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
