package io.spring.modulith.student.api;

import io.spring.modulith.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Student {
    private Long id;
    private String name;
}
