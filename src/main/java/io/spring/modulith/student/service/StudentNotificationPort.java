package io.spring.modulith.student.service;

import io.spring.modulith.student.StudentRecord;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface StudentNotificationPort {
    void notifyStudentCreated(StudentRecord studentRecord);
}
