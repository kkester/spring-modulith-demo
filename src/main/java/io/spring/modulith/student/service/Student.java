package io.spring.modulith.student.service;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    private String name;
}
