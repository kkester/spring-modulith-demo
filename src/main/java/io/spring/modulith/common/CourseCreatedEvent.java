package io.spring.modulith.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jmolecules.event.annotation.DomainEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DomainEvent
public class CourseCreatedEvent {
    private Long courseId;
    private String name;
}
