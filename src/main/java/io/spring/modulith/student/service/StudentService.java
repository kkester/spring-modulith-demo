package io.spring.modulith.student.service;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.ManageCoursesUseCase;
import io.spring.modulith.student.ManageStudentsUseCase;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Application
@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService implements ManageStudentsUseCase {

    private final StudentPersistPort studentPersistPort;
    private final StudentNotificationPort studentNotificationPort;
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
        StudentRecord savedStudentRecord = studentPersistPort.saveStudent(student);
        studentNotificationPort.notifyStudentCreated(savedStudentRecord);
        return studentPersistPort.retrieveAll();
    }

    @Override
    public StudentCoursesRecord assignStudentToCourse(Long studentId, Long courseId) {
        StudentRecord studentRecord = studentPersistPort.getStudent(studentId)
            .orElseThrow(StudentNotFoundException::new);
        List<CourseRecord> courses = manageCoursesUseCase.assignStudentToCourse(courseId, studentId);
        return new StudentCoursesRecord(studentRecord.id(), studentRecord.name(), courses);
    }

    @SneakyThrows
    @Override
    public void selectStudentsForCourse(Long courseId) {
        log.info("Selecting Students for New Course {}", courseId);
        Thread.sleep(15000);
        Random random = new Random();
        studentPersistPort.retrieveAll().stream()
            .filter(studentRecord -> random.nextInt(100) > 60)
            .forEach(studentRecord -> manageCoursesUseCase.assignStudentToCourse(courseId, studentRecord.id()));
    }
}
