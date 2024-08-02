package io.spring.modulith.student;

import io.spring.modulith.course.CourseRecord;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

import java.util.List;

@PrimaryPort
public interface ManageStudentsUseCase {
    List<StudentRecord> getAllStudents();
    StudentCoursesRecord getStudentById(Long id);
    List<StudentRecord> createStudentWithName(String name);
    StudentCoursesRecord assignStudentToCourse(Long studentId, Long courseId);
    void selectStudentsForCourse(CourseRecord courseRecord);
}
