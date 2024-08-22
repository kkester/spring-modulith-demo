package io.spring.modulith.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jmolecules.event.annotation.DomainEvent;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DomainEvent
public class StudentCreatedEvent {
    private Long studentId;
}
