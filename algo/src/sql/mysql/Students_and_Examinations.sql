use leet_code;

CREATE TABLE Students (
    student_id int,
    student_name varchar(20)
);

INSERT INTO Students (student_id, student_name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(13, 'John'),
(6, 'Alex');

CREATE TABLE Subjects (
    subject_name varchar(20)
);

INSERT INTO Subjects (subject_name) VALUES
('Math'),
('Physis'),
('Programming');

CREATE TABLE Examinations (
    student_id int,
    subject_name varchar(20)
);

INSERT INTO Examinations (student_id, subject_name) VALUES
(1, 'Math'),
(1, 'Physis'),
(1, 'Programming'),
(2, 'Programming'),
(1, 'Physis'),
(1, 'Math'),
(13, 'Math'),
(13, 'Programming'),
(13, 'Physis'),
(2, 'Math'),
(1, 'Math');

SELECT
    A.student_id,
    A.student_name,
    A.subject_name,
    IFNULL(B.attended_exams, 0) as attended_exams
FROM  (
   SELECT A.student_id,
          A.student_name,
          B.subject_name
   FROM Students AS A
   CROSS JOIN Subjects AS B
) AS A
LEFT JOIN (
    SELECT
        student_id,
        subject_name,
        count(student_id) as attended_exams
    FROM Examinations GROUP BY student_id, subject_name
)
AS B
ON A.student_id = B.student_id
AND A.subject_name = B.subject_name
ORDER BY A.student_id, A.subject_name;


SELECT * FROM Subjects AS A
LEFT JOIN (
    SELECT A.student_id, B.subject_name FROM Students AS A
    LEFT JOIN Examinations AS B
    ON A.student_id = B.student_id
    GROUP BY A.student_id, B.subject_name
) AS B
ON A.subject_name = B.subject_name




