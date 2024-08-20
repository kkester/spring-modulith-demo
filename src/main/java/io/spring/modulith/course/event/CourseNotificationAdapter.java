package io.spring.modulith.course.event;

import io.spring.modulith.common.CourseCreatedEvent;
import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.service.CourseNotificationPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
@Slf4j
public class CourseNotificationAdapter implements CourseNotificationPort {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void notifyCourseCreated(CourseRecord courseRecord) {
        log.info("Publishing Event for New Course Record {}", courseRecord);
        eventPublisher.publishEvent(new CourseCreatedEvent(courseRecord.id()));
    }
}
