package io.spring.modulith.course;

import io.spring.modulith.course.service.Course;

import java.util.List;

public interface CourseModelPort {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    List<Course> createCourseFrom(Course course);
    List<Course> getCourseByStudentId(Long studentId);
}
