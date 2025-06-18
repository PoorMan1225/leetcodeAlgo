USE leet_code;

-- 각 부서멸 세명까지만 출력을 하는데 동점인 경우는 모두 포함해야 한다.
-- 순서는 상관없다.
-- 윈도우 함수 사용.
SELECT R.department as Department,
       R.employee as Employee,
       R.salary as Salary
FROM (SELECT A.name as employee,
             A.salary,
             A.departmentid,
             B.name as department,
             DENSE_RANK() OVER (PARTITION BY A.departmentid ORDER BY A.salary DESC) AS rn
      FROM EMPLOYEE2 AS A
      INNER JOIN DEPARTMENT AS B
        ON A.departmentid = B.id) AS R
WHERE R.rn <= 3;

