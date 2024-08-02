package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.ManageCoursesUseCase;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Application
@Service
@RequiredArgsConstructor
public class CourseService implements ManageCoursesUseCase {

    private final CoursePersistPort coursePersistPort;

    @Override
    public List<CourseRecord> getAllCourses() {
        return coursePersistPort.retrieveAll();
    }

    @Override
    public CourseRecord getCourseById(Long id) {
        return coursePersistPort.getCourse(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public List<CourseRecord> createCourseFrom(CourseRecord course) {
        coursePersistPort.saveCourse(course);
        return coursePersistPort.retrieveAll();
    }

    @Override
    public List<CourseRecord> getCourseByStudentId(Long studentId) {
        return coursePersistPort.getCourseByStudentId(studentId);
    }

    @Override
    public List<CourseRecord> assignStudentToCourse(Long courseId, Long studentId) {
        coursePersistPort.assignStudentToCourse(courseId,studentId);
        return getCourseByStudentId(studentId);
    }
}
