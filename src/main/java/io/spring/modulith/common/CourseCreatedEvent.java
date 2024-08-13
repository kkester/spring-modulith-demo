package io.spring.modulith.common;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CourseCreatedEvent extends ApplicationEvent {
    private final Long courseId;
    public CourseCreatedEvent(Long courseId) {
        super(courseId);
        this.courseId = courseId;
    }
}
