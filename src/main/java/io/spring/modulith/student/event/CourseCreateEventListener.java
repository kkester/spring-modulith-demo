package io.spring.modulith.student.event;

import io.spring.modulith.common.CourseCreatedEvent;
import io.spring.modulith.student.ManageStudentsUseCase;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@PrimaryAdapter
@Component
@RequiredArgsConstructor
public class CourseCreateEventListener {

    private final ManageStudentsUseCase manageStudentsUseCase;

    @EventListener
    public void handle(CourseCreatedEvent event) {
        manageStudentsUseCase.selectStudentsForCourse(event.getCourseId());
    }
}
