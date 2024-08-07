package io.spring.modulith.student;

import io.spring.modulith.course.CourseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jmolecules.architecture.onion.classical.InfrastructureRing;
import org.jmolecules.architecture.onion.simplified.DomainRing;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
@DomainRing
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<CourseEntity> courses = new ArrayList<>();

    public void addCourse(CourseEntity courseEntity) {
        courses.add(courseEntity);
        List<StudentEntity> students = courseEntity.getStudents();
        if (students == null) {
            students = new ArrayList<>();
            courseEntity.setStudents(students);
        }
        students.add(this);
    }
}
