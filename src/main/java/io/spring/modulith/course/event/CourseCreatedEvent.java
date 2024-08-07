package io.spring.modulith.course.event;

import io.spring.modulith.course.Course;
import org.jmolecules.architecture.onion.classical.DomainServiceRing;
import org.springframework.context.ApplicationEvent;

@DomainServiceRing
public class CourseCreatedEvent extends ApplicationEvent {

    private final Long courseId;

    public CourseCreatedEvent(Course source) {
        super(source);
        this.courseId = source.getId();
    }

    public Long getCourseRecordId() {
        return courseId;
    }
}
