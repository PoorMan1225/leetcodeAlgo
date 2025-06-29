USE leet_code;

CREATE TABLE MyNumbers (
    num int
);

INSERT INTO MyNumbers VALUES
(8),
(8),
(3),
(3),
(1),
(4),
(5),
(6);

INSERT INTO MyNumbers VALUES
(7),
(7);

-- 필터링 하는 방법.
WITH NumAndNext AS (
    SELECT num,
           LEAD(num) over (ORDER BY num) AS nextNum
    FROM MyNumbers
)
SELECT MAX(num) as num FROM MyNumbers AS A
WHERE NOT EXISTS(
    SELECT num
    FROM NumAndNext
    WHERE num = nextNum
    AND A.num = num
);

-- 그룹바이 방법
SELECT MAX(R.num) as num
FROM (
     SELECT num,
            count(*) as cnt
     FROM MyNumbers
     GROUP BY num
     HAVING cnt = 1
) AS R

