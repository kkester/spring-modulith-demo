package io.spring.modulith.student.persist;

import io.spring.modulith.course.Course;
import io.spring.modulith.course.persist.CourseEntity;
import io.spring.modulith.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
@InfrastructureRing
public class StudentEntity implements Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<CourseEntity> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (course instanceof CourseEntity courseEntity) {
            courses.add(courseEntity);
            List<StudentEntity> students = courseEntity.getStudents();
            if (students == null) {
                students = new ArrayList<>();
                courseEntity.setStudents(students);
            }
            students.add(this);
        }
    }
}
