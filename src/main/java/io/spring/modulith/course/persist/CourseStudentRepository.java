package io.spring.modulith.course.persist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepository extends JpaRepository<CourseStudentEntity, CourseStudentEntity> {
}
