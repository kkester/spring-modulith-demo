package io.spring.modulith.course;

import java.util.List;

public interface CourseModelPort {
    List<CourseRecord> getAllCourses();
    CourseRecord getCourseById(Long id);
    List<CourseRecord> createCourseFrom(CourseRecord course);
    List<CourseRecord> getCourseByStudentId(Long studentId);
}
