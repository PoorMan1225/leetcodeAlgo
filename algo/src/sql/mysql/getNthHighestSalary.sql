USE leet_code;

SELECT *
FROM leet_code.employee;

INSERT INTO leet_code.employee (salary) VALUE
    (100),
    (100),
    (200),
    (300),
    (400),
    (500);

-- 윈도우 함수 사용불가.
-- 변수 파라미터 넣기 불가.

USE leet_code;


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    RETURN (
        SELECT
            CASE WHEN N < 1 THEN NULL
                 WHEN N > COUNT(*) THEN NULL
                 ELSE MIN(salary) END
        FROM (
          SELECT DISTINCT salary
          FROM employee
          ORDER BY salary DESC
          LIMIT N) AS temp
    );
END;


