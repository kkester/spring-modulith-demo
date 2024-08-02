package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseModelPort;
import io.spring.modulith.course.CourseRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements CourseModelPort {

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
}
