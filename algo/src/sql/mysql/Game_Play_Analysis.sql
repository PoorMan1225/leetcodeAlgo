use leet_code;

CREATE TABLE Activity
(
    player_id    int,
    device_id    int,
    event_date   varchar(10),
    games_played int
);

INSERT INTO Activity
VALUES (1, 2, '2016-03-01', 5),
       (1, 2, '2016-03-02', 6),
       (2, 3, '2017-06-25', 1),
       (3, 1, '2016-03-02', 0),
       (3, 4, '2018-07-03', 5);

SELECT player_id, MIN(event_date) as first_login
FROM Activity
GROUP BY player_id;

-- 플레이어별 최초 접속일 다음날에 접속한 아이디를 구함.
SELECT CAST(A.login_count / B.all_count AS DECIMAL(4, 2)) as fraction
FROM (
     SELECT COUNT(*) as login_count
     FROM Activity A
     INNER JOIN
         (SELECT player_id,
                 MIN(event_date) AS event_date
            FROM Activity
        GROUP BY player_id) B
     ON A.player_id = B.player_id
     AND A.event_date = DATE_ADD(B.event_date, INTERVAL 1 DAY)
) AS A
INNER JOIN (
    -- 전체 테이블에 대한 player_id 의 중복을 제거한 값을 가져온다.
    SELECT COUNT(distinct player_id) as all_count
    FROM Activity
) AS B
ON 1=1;

-- 첫번재 로그인한 날짜 아이디 중복제거 후 가져오기
WITH FirstLogin AS (
    SELECT
        player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
),
-- 첫번째 로그인 이후 둘쨋날에도 로그인 한 사람 가져오기
ConsecutiveLogin AS (
    SELECT a.player_id
    FROM Activity a
    INNER JOIN FirstLogin fl
        ON a.player_id = fl.player_id
       AND a.event_date = DATE_ADD(fl.first_login, INTERVAL 1 DAY)
)
-- 둘쨋날에도 로그인 한 사람 수 / 전체 사람 수
SELECT
ROUND(
COUNT(DISTINCT cl.player_id) * 1.0 / COUNT(DISTINCT fl.player_id),
2
) AS fraction
FROM FirstLogin fl
LEFT JOIN ConsecutiveLogin cl
ON fl.player_id = cl.player_id;






