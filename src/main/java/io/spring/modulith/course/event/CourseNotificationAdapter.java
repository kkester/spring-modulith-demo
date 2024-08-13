package io.spring.modulith.course.event;

import io.spring.modulith.common.CourseCreatedEvent;
import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.service.CourseNotificationPort;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
public class CourseNotificationAdapter implements CourseNotificationPort {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void notifyCourseCreated(CourseRecord courseRecord) {
        eventPublisher.publishEvent(new CourseCreatedEvent(courseRecord.id()));
    }
}
