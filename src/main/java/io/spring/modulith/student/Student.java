package io.spring.modulith.student;

import org.jmolecules.architecture.onion.classical.DomainModelRing;

@DomainModelRing
public interface Student {
    Long getId();
    String getName();
    void setName(String name);
}
