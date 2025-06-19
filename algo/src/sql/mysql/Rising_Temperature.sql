USE leet_code;

CREATE TABLE Weather
(
    id          int primary key auto_increment,
    recordDate  date,
    temperature int
);

INSERT INTO Weather (recordDate, temperature)
VALUES ('2015-01-01', 10),
       ('2015-01-02', 25),
       ('2015-01-03', 20),
       ('2015-01-04', 30);

SELECT A.id as id
FROM Weather A
         LEFT JOIN Weather B
                   ON A.id - 1 = B.id
WHERE A.temperature > B.temperature;

-- 키가 없는것 같아서 만들었는데 하루단위면 on 조건을 그냥 하루차이의 날짜로 해도 상관 없었을것 같다.
WITH ORDER_DATE AS (
    SELECT ROW_NUMBER() over (ORDER BY recordDate) as rn,
           id,
           temperature,
           recordDate
    FROM Weather
)

SELECT * FROM ORDER_DATE AS A
LEFT JOIN ORDER_DATE AS B
ON A.rn - 1 = B.rn
WHERE A.temperature > B.temperature
AND DATE_SUB(A.recordDate, INTERVAL 1 DAY) = B.recordDate;

