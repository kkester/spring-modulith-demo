package io.spring.modulith.course.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jmolecules.architecture.onion.simplified.ApplicationRing;

@ApplicationRing
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private Integer level;
}
