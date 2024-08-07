package io.spring.modulith.student;

import io.spring.modulith.course.Course;
import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
public interface Student {
    Long getId();
    String getName();
    void setName(String name);
    void addCourse(Course courseEntity);
}
