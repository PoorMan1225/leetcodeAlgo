USE leet_code;

CREATE TABLE Triangle
(
    x int,
    y int,
    z int
);

INSERT INTO Triangle (x, y, z)
VALUES (13, 15, 30),
       (10, 20, 15);


-- 어떤 변이 가장 길지 모르기 때문에 그냥 세조건을 모두 크다로 해버리면
-- 어차피 두변의 합이 무조건 한변보다 커야 하기 때문에 삼각형이 된다.
SELECT
    x,
    y,
    z,
    CASE
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        WHEN x = y AND y = z THEN 'YES'
        ELSE 'No'
        END AS triangle
FROM Triangle;


-- 가장 긴 변을 구하고 그에 대해 나머지 두 변의 합이 더 큰지만 검사
SELECT *,
       CASE
           WHEN x + y + z - GREATEST(x, y, z) > GREATEST(x, y, z)
               THEN 'Yes'
           ELSE 'No'
           END AS triangle
FROM Triangle