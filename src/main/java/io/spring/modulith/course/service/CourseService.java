package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseModelPort;
import io.spring.modulith.course.api.CourseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseModelPort {

    private final CoursePersistPort coursePersistPort;

    @Override
    public List<Course> getAllCourses() {
        return coursePersistPort.retrieveAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return coursePersistPort.getCourse(id)
            .orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public List<Course> createCourseFrom(Course course) {
        coursePersistPort.saveCourse(course);
        return coursePersistPort.retrieveAll();
    }

    @Override
    public List<Course> getCourseByStudentId(Long studentId) {
        return null;
    }
}
