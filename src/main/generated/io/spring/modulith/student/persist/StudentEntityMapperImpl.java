package io.spring.modulith.student.persist;

import io.spring.modulith.course.persist.CourseEntity;
import io.spring.modulith.student.CourseRecord;
import io.spring.modulith.student.StudentCoursesRecord;
import io.spring.modulith.student.StudentRecord;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-06T16:33:48-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StudentEntityMapperImpl implements StudentEntityMapper {

    @Override
    public StudentRecord getRecordFromEntity(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = studentEntity.getId();
        name = studentEntity.getName();

        StudentRecord studentRecord = new StudentRecord( id, name );

        return studentRecord;
    }

    @Override
    public StudentCoursesRecord studentEntityToStudentCoursesRecord(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<CourseRecord> courses = null;

        id = studentEntity.getId();
        name = studentEntity.getName();
        courses = courseEntityListToCourseRecordList( studentEntity.getCourses() );

        StudentCoursesRecord studentCoursesRecord = new StudentCoursesRecord( id, name, courses );

        return studentCoursesRecord;
    }

    @Override
    public StudentEntity getEntityFromRecord(StudentRecord student) {
        if ( student == null ) {
            return null;
        }

        StudentEntity.StudentEntityBuilder studentEntity = StudentEntity.builder();

        studentEntity.id( student.id() );
        studentEntity.name( student.name() );

        return studentEntity.build();
    }

    @Override
    public CourseRecord courseEntityToCourseRecord(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Integer level = null;

        id = courseEntity.getId();
        name = courseEntity.getName();
        level = courseEntity.getLevel();

        CourseRecord courseRecord = new CourseRecord( id, name, level );

        return courseRecord;
    }

    protected List<CourseRecord> courseEntityListToCourseRecordList(List<CourseEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CourseRecord> list1 = new ArrayList<CourseRecord>( list.size() );
        for ( CourseEntity courseEntity : list ) {
            list1.add( courseEntityToCourseRecord( courseEntity ) );
        }

        return list1;
    }
}
