package io.spring.modulith.student;

import io.spring.modulith.course.Course;

public interface AddCourseToStudentAction {
    void addCourse(Course courseEntity);
}
