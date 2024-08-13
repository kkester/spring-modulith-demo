package io.spring.modulith.course.service;

import io.spring.modulith.course.CourseRecord;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface CourseNotificationPort {
    void notifyCourseCreated(CourseRecord courseRecord);
}
