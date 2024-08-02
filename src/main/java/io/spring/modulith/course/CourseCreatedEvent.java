package io.spring.modulith.course;

import org.springframework.context.ApplicationEvent;

public class CourseCreatedEvent extends ApplicationEvent {
    public CourseCreatedEvent(CourseRecord source) {
        super(source);
    }
    public CourseRecord getCourseRecord() {
        return (CourseRecord) this.source;
    }
}
