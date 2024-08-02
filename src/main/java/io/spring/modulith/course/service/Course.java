package io.spring.modulith.course.service;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long id;
    private String name;
    private Integer level;
}
