USE leet_code;

CREATE TABLE Tree (
    id int primary key auto_increment,
    p_id int
);

INSERT INTO Tree (p_id) VALUES
(NULL),
(1),
(1),
(2),
(2);

--
WITH RECURSIVE Recur AS (
    SELECT id, CAST(id AS CHAR) AS path
    FROM Tree
    WHERE p_id IS NULL
    UNION ALL
    SELECT A.id, CONCAT(B.path, '->', A.id) AS path
    FROM Tree AS A
    INNER JOIN Recur AS B
    ON A.p_id = B.id
)
SELECT * FROM Recur;


SELECT A.id,
       CASE WHEN A.p_id IS NULL THEN 'Root'
            WHEN EXISTS(SELECT 1 FROM Tree WHERE p_id = A.id) THEN 'Inner'
            ELSE 'Leaf' END AS type
FROM Tree AS A;

-- 데이터 셋이 많을 경우 left 조인이 더 좋은 선택지가 될 수 있다.
SELECT DISTINCT
       A.id,
       CASE
           WHEN A.p_id IS NULL THEN 'Root'
           WHEN B.id IS NOT NULL THEN 'Inner'
           ELSE 'Leaf'
           END AS type
FROM Tree AS A
LEFT JOIN Tree AS B ON B.p_id = A.id;