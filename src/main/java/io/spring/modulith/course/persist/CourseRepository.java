package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    @Query(value = "SELECT c.* from course c, course_student cs where cs.student_id=?1 and cs.course_id = c.id", nativeQuery = true)
    List<CourseRecord> findAllByStudentId(Long studentId);
}
