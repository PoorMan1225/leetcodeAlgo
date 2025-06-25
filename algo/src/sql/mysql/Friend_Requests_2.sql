USE leet_code;

CREATE TABLE RequestAccepted
(
    requester_id int,
    accepter_id  int,
    accept_date  date
);

INSERT INTO RequestAccepted (requester_id, accepter_id, accept_date)
VALUES (1, 2, '2016/06/03'),
       (1, 3, '2016/06/08'),
       (2, 3, '2016/06/08'),
       (3, 4, '2016/06/09');

WITH AcceptCount AS (
    -- accept id 의 카운팅을 가지고온다.
    SELECT COUNT(*)    as cnt,
           accepter_id as id
    FROM RequestAccepted
    GROUP BY accepter_id
), RequestCount AS (
    -- request id 의 카운팅을 가지고 온다.
    SELECT COUNT(*)     as cnt,
           requester_id as id
    FROM RequestAccepted
    GROUP BY requester_id
)

-- ORDER BY 는 ALIAS 사용 가능 왜냐하면 테이블 결과 셋에서 정렬 하니가
-- GROUP BY 는 ALIAS 사용 불가 왜냐하면 테이블 결과 셋을 만들어야 하니까
-- WHERE 도 마찬가지로 적용 가능.
SELECT SUM(cnt) as num,
       R.id
FROM (
      SELECT * FROM AcceptCount
      UNION ALL
      SELECT *FROM RequestCount
) AS R
GROUP BY R.id
ORDER BY num DESC
LIMIT 1





