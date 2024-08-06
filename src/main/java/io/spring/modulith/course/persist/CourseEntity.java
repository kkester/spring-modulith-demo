package io.spring.modulith.course.persist;

import io.spring.modulith.student.persist.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jmolecules.architecture.layered.InfrastructureLayer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course")
@InfrastructureLayer
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer level;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> students = new ArrayList<>();

    public void addStudent(StudentEntity studentEntity) {
        students.add(studentEntity);
        studentEntity.getCourses().add(this);
    }
}
