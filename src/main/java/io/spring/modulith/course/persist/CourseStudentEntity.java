package io.spring.modulith.course.persist;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course_student")
@IdClass(CourseStudentEntity.class)
public class CourseStudentEntity implements Serializable {
    @Id
    private Long courseId;
    @Id
    private Long studentId;
}
