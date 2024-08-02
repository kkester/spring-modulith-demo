package io.spring.modulith.student.service;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.ManageCoursesUseCase;
import io.spring.modulith.student.ManageStudentsUseCase;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Application
@Service
@RequiredArgsConstructor
public class StudentService implements ManageStudentsUseCase {

    private final StudentPersistPort studentPersistPort;
    private final ManageCoursesUseCase manageCoursesUseCase;

    public StudentCoursesRecord getStudentById(Long id) {
        StudentRecord studentRecord = studentPersistPort.getStudent(id)
            .orElseThrow(StudentNotFoundException::new);
        List<CourseRecord> courses = manageCoursesUseCase.getCourseByStudentId(id);
        return new StudentCoursesRecord(studentRecord.id(), studentRecord.name(), courses);
    }

    public List<StudentRecord> getAllStudents() {
        return studentPersistPort.retrieveAll();
    }

    public List<StudentRecord> createStudentWithName(String name) {
        StudentRecord student = new StudentRecord(null, name);
        studentPersistPort.saveStudent(student);
        return studentPersistPort.retrieveAll();
    }

    @Override
    public StudentCoursesRecord assignStudentToCourse(Long studentId, Long courseId) {
        StudentRecord studentRecord = studentPersistPort.getStudent(studentId)
            .orElseThrow(StudentNotFoundException::new);
        List<CourseRecord> courses = manageCoursesUseCase.assignStudentToCourse(courseId, studentId);
        return new StudentCoursesRecord(studentRecord.id(), studentRecord.name(), courses);
    }
}
