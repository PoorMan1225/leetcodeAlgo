use leet_code;

CREATE TABLE Salary (
    id int primary key auto_increment,
    name varchar(20),
    sex enum('m', 'f'),
    salary int
);

INSERT INTO Salary (name, sex, salary) VALUES
('A', 'm', 2500),
('B', 'f', 1500),
('C', 'm', 5500),
('D', 'f', 500);

START TRANSACTION;
UPDATE Salary set sex = IF(sex = 'm', 'f', 'm');
SELECT * FROM Salary;
ROLLBACK;


SELECT * FROM Salary;

