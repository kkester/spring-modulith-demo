package io.spring.modulith.student.event;

import io.spring.modulith.common.StudentCreatedEvent;
import io.spring.modulith.student.StudentRecord;
import io.spring.modulith.student.service.StudentNotificationPort;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
public class StudentNotificationAdapter implements StudentNotificationPort {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void notifyStudentCreated(StudentRecord studentRecord) {
        eventPublisher.publishEvent(new StudentCreatedEvent(studentRecord.id()));
    }
}
