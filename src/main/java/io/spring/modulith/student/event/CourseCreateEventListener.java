package io.spring.modulith.student.event;

import io.spring.modulith.common.CourseCreatedEvent;
import io.spring.modulith.student.ManageStudentsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@PrimaryAdapter
@Component
@RequiredArgsConstructor
@Slf4j
public class CourseCreateEventListener {

    private final ManageStudentsUseCase manageStudentsUseCase;

    @ApplicationModuleListener
    public void handle(CourseCreatedEvent event) {
        log.info("Received Event for Course Created {} on VT: {}", event.getCourseId(), Thread.currentThread().isVirtual());
        manageStudentsUseCase.selectStudentsForCourse(event.getCourseId());
    }
}
