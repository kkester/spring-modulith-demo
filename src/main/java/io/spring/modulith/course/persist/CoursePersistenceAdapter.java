package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import io.spring.modulith.course.service.CoursePersistPort;
import io.spring.modulith.entity.course.CourseEntity;
import io.spring.modulith.entity.course.CourseRepository;
import io.spring.modulith.entity.student.StudentEntity;
import io.spring.modulith.entity.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@SecondaryAdapter
@Component
@RequiredArgsConstructor
public class CoursePersistenceAdapter implements CoursePersistPort {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseEntityMapper mapper;

    @Override
    public List<CourseRecord> retrieveAll() {
        return courseRepository.findAll().stream()
            .map(mapper::courseEntityToCourseRecord)
            .toList();
    }

    @Override
    public Optional<CourseRecord> getCourse(Long id) {
        return courseRepository.findById(id)
            .map(mapper::courseEntityToCourseRecord);
    }

    @Override
    public CourseRecord saveCourse(CourseRecord course) {
        CourseEntity courseEntity = mapper.courseRecordToCourseEntity(course);
        CourseEntity savedEntity = courseRepository.save(courseEntity);
        return mapper.courseEntityToCourseRecord(savedEntity);
    }

    @Override
    public List<CourseRecord> getCourseByStudentId(Long studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow();
        return studentEntity.getCourses().stream()
            .map(mapper::courseEntityToCourseRecord)
            .toList();
    }

    @Override
    public void assignStudentToCourse(Long courseId, Long studentId) {
        CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow();
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow();
        courseEntity.addStudent(studentEntity);
        studentRepository.save(studentEntity);
    }
}
