package io.spring.modulith.student.event;

import io.spring.modulith.course.event.CourseCreatedEvent;
import io.spring.modulith.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseCreateEventListener {

    private final StudentService studentService;

    @EventListener
    public void handle(CourseCreatedEvent event) {
        studentService.selectStudentsForCourse(event.getCourseRecordId());
    }
}
