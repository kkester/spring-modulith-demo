package io.spring.modulith.course.persist;

import io.spring.modulith.student.persist.StudentEntity;
import jakarta.persistence.*;
import lombok.*;
import org.jmolecules.architecture.layered.InfrastructureLayer;

import java.util.List;

@Getter
@Setter
@Builder
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
    @ManyToMany
    private List<StudentEntity> students;
}
