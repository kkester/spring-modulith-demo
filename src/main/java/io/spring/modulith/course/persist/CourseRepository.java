package io.spring.modulith.course.persist;

import io.spring.modulith.course.CourseRecord;
import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Adapter
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    @Query(value = """
        SELECT new io.spring.modulith.course.CourseRecord(c.id, c.name, c.level) 
        from course c, course_student cs 
        where cs.studentId=?1 and cs.courseId = c.id
        """)
    List<CourseRecord> findAllByStudentId(Long studentId);
}
