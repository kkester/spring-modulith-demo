package io.spring.modulith.common;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StudentCreatedEvent extends ApplicationEvent {
    private final Long studentId;
    public StudentCreatedEvent(Long studentId) {
        super(studentId);
        this.studentId = studentId;
    }
}
