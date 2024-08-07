package io.spring.modulith.student.api;

import io.spring.modulith.course.api.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;

import java.util.List;

@ApplicationRing
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private List<CourseDto> courses;
}
