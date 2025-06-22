USE leet_code;

CREATE TABLE Employee3
(
    id         int primary key,
    name       varchar(20),
    department varchar(10),
    managerId  int
);

INSERT INTO Employee3 (id, name, department, managerId)
VALUES (101, 'John', 'A', null),
       (102, 'Dan', 'A', 101),
       (103, 'James', 'A', 101),
       (104, 'Amy', 'A', 101),
       (105, 'Anne', 'A', 101),
       (106, 'Ron', 'B', 101);


-- 최소 5개의 직접보고서가 있는 관리자 를 찾기 위한 솔루션
SELECT B.name FROM Employee3 A
INNER JOIN Employee3 B
ON A.managerId = b.id
GROUP BY A.managerId
HAVING COUNT(A.managerId) >= 5;




