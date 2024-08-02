DELETE FROM course_student;
DELETE FROM student;
INSERT INTO student (name)
VALUES ('Bobby Tables'),
       ('Mocky Springfield'),
       ('Monoque Flux');

DELETE FROM course;
INSERT INTO course (name,level)
VALUES ('History', 101),
       ('Math', 202),
       ('Science', 303);
