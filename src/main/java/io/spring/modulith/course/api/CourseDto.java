package io.spring.modulith.course.api;

import io.spring.modulith.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto implements Course {
    private Long id;
    private String name;
    private Integer level;
}
