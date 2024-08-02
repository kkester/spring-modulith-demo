CREATE TABLE IF NOT EXISTS student
(
    id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar
);

CREATE TABLE IF NOT EXISTS course
(
    id    bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  varchar,
    level int
);

CREATE TABLE IF NOT EXISTS course_student
(
    course_id    bigint REFERENCES course(id),
    student_id    bigint REFERENCES student(id),
    PRIMARY KEY (course_id,student_id)
);
