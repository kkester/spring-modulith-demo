package io.spring.modulith.student.service;

import io.spring.modulith.course.ManageCoursesUseCase;
import io.spring.modulith.student.ManageStudentsUseCase;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Application
@Service
@RequiredArgsConstructor
public class StudentService implements ManageStudentsUseCase {

    private final StudentPersistPort studentPersistPort;
    private final ManageCoursesUseCase manageCoursesUseCase;

    public StudentCoursesRecord getStudentById(Long id) {
        return studentPersistPort.getStudent(id)
            .orElseThrow(StudentNotFoundException::new);
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
        manageCoursesUseCase.assignStudentToCourse(courseId, studentId);
        return studentPersistPort.getStudent(studentId)
            .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void selectStudentsForCourse(Long courseId) {
        Random random = new Random();
        studentPersistPort.retrieveAll().stream()
            .filter(studentRecord -> random.nextInt(100) > 60)
            .forEach(studentRecord -> manageCoursesUseCase.assignStudentToCourse(courseId, studentRecord.id()));
    }
}
