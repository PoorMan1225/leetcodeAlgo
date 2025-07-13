USE leet_code;

CREATE TABLE Queue (
    person_id int,
    person_name varchar(20),
    weight int,
    turn int
);

INSERT INTO Queue (person_id, person_name, weight, turn) VALUES
(5, 'Alice', 250, 1),
(4, 'Bob', 170, 5),
(3, 'Alex', 350, 2),
(6, 'Jhon Cena', 400, 3),
(1, 'Winston', 500, 6),
(2, 'Marie', 200, 4);


-- O(N) 변수 사용 솔류션
-- 재귀 솔루션
WITH RECURSIVE CTE AS (
    SELECT turn, person_name, weight AS total_weight
    FROM Queue
    WHERE turn = 1
    UNION ALL
    SELECT B.turn, B.person_name, A.total_weight + B.weight
    FROM CTE A
             JOIN Queue B ON B.turn = A.turn + 1
    -- 재귀 가지치기
    WHERE A.total_weight + B.weight <= 1000
)
SELECT person_name
FROM CTE
ORDER BY total_weight DESC
LIMIT 1;

-- 윈도우 함수가 인덱스 영향도 잘받고
-- 재귀는 또 찾아서 붙여야 하기 때문에 O(N2) 이 될 수 있음. 
with weight_table as (
    select person_name,weight,
           sum(weight) over(order by turn) as total_weight,
           turn
    from Queue
    order by turn )
select person_name
from weight_table
where total_weight<=1000
order by turn desc
limit 1