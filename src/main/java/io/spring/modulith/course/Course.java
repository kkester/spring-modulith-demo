package io.spring.modulith.course;

import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
public interface Course {
    Long getId();
    String getName();
    void setName(String name);
    Integer getLevel();
    void setLevel(Integer level);
}
