package io.spring.modulith.course.service;

import java.util.List;
import java.util.Optional;

public interface CoursePersistPort {
    List<Course> retrieveAll();
    Optional<Course> getCourse(Long id);
    Course saveCourse(Course student);
}
