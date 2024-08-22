package io.spring.modulith.course.event;

import io.spring.modulith.common.StudentCreatedEvent;
import io.spring.modulith.course.ManageCoursesUseCase;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@PrimaryAdapter
@Component
@RequiredArgsConstructor
public class StudentCreateEventListener {

    private final ManageCoursesUseCase manageCoursesUseCase;

    @Async
    @EventListener
    public void handle(StudentCreatedEvent event) {
        manageCoursesUseCase.selectCoursesForStudent(event.getStudentId());
    }
}
