package io.spring.modulith.course.service;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.contextpropagation.ObservationThreadLocalAccessor;
import io.micrometer.tracing.annotation.NewSpan;
import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.ManageCoursesUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Application
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService implements ManageCoursesUseCase {

    private final CoursePersistPort coursePersistPort;
    private final CourseNotificationPort courseNotificationPort;
    private final Executor taskExecutor;

    @Override
    public List<CourseRecord> getAllCourses() {
        return coursePersistPort.retrieveAll();
    }

    @Override
    public CourseRecord getCourseById(Long id) {
        return coursePersistPort.getCourse(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    @Transactional
    @Override
    public List<CourseRecord> createCourseFrom(CourseRecord course) {
        log.info("Saving New Course Record {}", course);
        CourseRecord savedCourse = coursePersistPort.saveCourse(course);
        courseNotificationPort.notifyCourseCreated(savedCourse);
        return coursePersistPort.retrieveAll();
    }

    @Async
    @NewSpan("get-course-by-student-id")
    @Override
    public Future<List<CourseRecord>> getCourseByStudentId(Long studentId) {
        Observation observation = ObservationThreadLocalAccessor.getInstance().getValue();
        return CompletableFuture.supplyAsync(() -> {
            ObservationThreadLocalAccessor.getInstance().setValue(observation);
            log.info("Getting Course Records by student id {}", studentId);
            return coursePersistPort.getCourseByStudentId(studentId);
        }, taskExecutor);
    }

    @Override
    public List<CourseRecord> assignStudentToCourse(Long courseId, Long studentId) {
        log.info("Assigning student {} to course {}", studentId, courseId);
        coursePersistPort.assignStudentToCourse(courseId,studentId);
        return coursePersistPort.getCourseByStudentId(studentId);
    }

    @Override
    public void selectCoursesForStudent(Long studentId) {
        Random random = new Random();
        coursePersistPort.retrieveAll().stream()
            .filter(courseRecord -> random.nextInt(100) > 60)
            .forEach(courseRecord -> assignStudentToCourse(courseRecord.id(), studentId));
    }
}
