use leet_code;

CREATE TABLE Stadium
(
    id         int primary key auto_increment,
    visit_date date,
    people     int
);

INSERT INTO Stadium (visit_date, people)
VALUES ('2017-01-01', 10),
       ('2017-01-02', 109),
       ('2017-01-03', 150),
       ('2017-01-04', 99),
       ('2017-01-05', 145),
       ('2017-01-06', 1455),
       ('2017-01-07', 199),
       ('2017-01-09', 188);


-- PEOPLE 수가 100 이상이 참석 해야 한다.
-- 난 조인 해서 겹치는게 없으면 정답이라고 봤는데
-- 이전 함수를 사용하는 방법이 있었다.
SELECT DISTINCT b.id, visit_date, people
FROM (SELECT id,
             LEAD(id, 1) over (ORDER BY id) as next1,
             LEAD(id, 2) over (ORDER BY id) as next2
      FROM Stadium
      WHERE people >= 100) AS K
         INNER JOIN stadium B
                    ON (K.id = B.id OR K.next1 = B.id OR K.next2 = B.id)
WHERE K.id + 1 = next1
  AND next1 + 1 = next2;

-- 이전함수 사용방식
WITH base AS (SELECT *,
                     LEAD(id, 1) OVER (ORDER BY id) AS next_id,
                     LEAD(id, 2) OVER (ORDER BY id) AS second_next_id,
                     LAG(id, 1) OVER (ORDER BY id)  AS last_id,
                     LAG(id, 2) OVER (ORDER BY id)  AS second_last_id
              FROM stadium
              WHERE people >= 100)
SELECT DISTINCT id, visit_date, people
FROM base
-- 이전 값과 1씩 차이나면 , 그리고 그 이전값과 1씩 차이나거나
-- 다음값과 1씩 차이나면, 그리그 그 다음값과 1씩 차이나면
WHERE (next_id - id = 1 AND id - last_id = 1)
   OR (second_next_id - next_id = 1 AND next_id - id = 1)
   OR (id - last_id = 1 AND last_id - second_last_id = 1)
ORDER BY visit_date;

-- union 방식 더 직관적이긴 하다.
select s1.*
from stadium s1
         join stadium s2 on s1.id = s2.id - 1
         join stadium s3 on s2.id = s3.id - 1
where s1.people >= 100
  and s2.people >= 100
  and s3.people >= 100
union
select s2.*
from stadium s1
         join stadium s2 on s1.id = s2.id - 1
         join stadium s3 on s2.id = s3.id - 1
where s1.people >= 100
  and s2.people >= 100
  and s3.people >= 100
union
select s3.*
from stadium s1
         join stadium s2 on s1.id = s2.id - 1
         join stadium s3 on s2.id = s3.id - 1
where s1.people >= 100
  and s2.people >= 100
  and s3.people >= 100
order by visit_date;

-- 와우 감탄만 나오는 최고의 방법
WITH stadium_with_rnk AS
         (
             -- 구한 랭크에서 id 에서 랭크를 빼게 되면 해당 아이디들이 모두 같은 값을 가지게 된다.
             SELECT id, visit_date, people, rnk, (id - rnk) AS island
             FROM (
                      -- 조건값을 필터링 하고 랭크를 구한다.
                      SELECT id, visit_date, people, RANK() OVER(ORDER BY id) AS rnk
                      FROM Stadium
                      WHERE people >= 100) AS t0
         )
SELECT id, visit_date, people
FROM stadium_with_rnk
-- 그다음 같은 값을 가진 island 중에서 그룹핑을 해서 3 이상인 것을 찾는다.
WHERE island IN (SELECT island
                 FROM stadium_with_rnk
                 GROUP BY island
                 HAVING COUNT(*) >= 3)
ORDER BY visit_date