use leet_code;

CREATE TABLE Project (
    project_id int,
    employee_id int
);


INSERT INTO Project (project_id, employee_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 4);

CREATE TABLE ProjectEmployee (
    employee_id int,
    name varchar(20),
    experience_years int
);

INSERT INTO ProjectEmployee (employee_id, name, experience_years) VALUES
(1, 'Khaled', 3),
(2, 'Ali', 2),
(3, 'John', 1),
(4, 'Doe', 2);

SELECT project_id,
       ROUND(AVG(experience_years), 2) as average_years
FROM Project A
INNER JOIN ProjectEmployee B
ON A.employee_id = B.employee_id
GROUP BY project_id
