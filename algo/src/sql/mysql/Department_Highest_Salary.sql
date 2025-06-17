use leet_code;

CREATE TABLE Employee2
(
    id           int primary key auto_increment,
    name         varchar(20),
    salary       int,
    departmentId int,
    foreign key (departmentId) references Department (id)
);

CREATE TABLE Department
(
    id   int primary key auto_increment,
    name varchar(10)
);

INSERT INTO Department (name)
VALUES ('IT'),
       ('Sales');


INSERT INTO Employee2 (name, salary, departmentId)
VALUES ('Joe', 70000, 1),
       ('Jim', 90000, 1),
       ('Henry', 80000, 2),
       ('Sam', 60000, 2),
       ('Max', 90000, 1);


-- 상관 서브 쿼리 컬럼에 있는 id 나 컬럼 정보를
-- Where 절에서 사용함 성능이 낮아질 수 있음
SELECT D.id,
       A.name,
       A.salary
FROM Employee2 AS A
         INNER JOIN Department D
                    on A.departmentId = D.id
WHERE salary = (SELECT MAX(E.salary)
                FROM Employee2 AS E
                WHERE E.departmentId = D.id);

-- 비상관 서브쿼리 IN 을 통해서 튜플 셋을 만들어서 그 Set 안에서 비교함
-- With 문으로 따로 Grouping 한 결과를 만들어서 조인하는 방법도 있음.
# SELECT dep.name
#            AS Department,
#        emp.name
#            AS Employee,
#        emp.salary
#            AS Salary
# FROM Employee emp
#          JOIN Department dep
#               ON emp.departmentId = dep.id
# WHERE (emp.salary, emp.departmentId)
#           IN (SELECT max(salary)
#                          AS salary,
#                      departmentId
#               FROM Employee
#               GROUP BY departmentId)