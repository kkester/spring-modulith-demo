package io.spring.modulith.course;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.List;
import java.util.concurrent.Future;

@PrimaryPort
public interface ManageCoursesUseCase {
    List<CourseRecord> getAllCourses();
    CourseRecord getCourseById(Long id);
    List<CourseRecord> createCourseFrom(CourseRecord course);
    Future<List<CourseRecord>> getCourseByStudentId(Long studentId);
    List<CourseRecord> assignStudentToCourse(Long courseId, Long studentId);
    void selectCoursesForStudent(Long studentId);
}
