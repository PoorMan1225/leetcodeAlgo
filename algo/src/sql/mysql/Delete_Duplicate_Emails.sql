USE leet_code;

WITH NUMBER AS (
    SELECT id, email, ROW_NUMBER() over (PARTITION BY person.email) AS RN FROM person
)
SELECT id, email FROM NUMBER WHERE RN = 1;

-- 중복 된 데이터 조회.
SELECT MIN(id) as id, email FROM person GROUP BY email;

-- 중복된 이메일 삭제 쿼리
START TRANSACTION; -- 자동으로 SET AUTOCOMMIT = 0 으로 만듬
    DELETE A
    FROM person A
    INNER JOIN person B
    ON A.email = B.email
    WHERE A.id > B.id;

    SELECT * FROM person;
ROLLBACK;

INSERT INTO person (email) VALUES ('john@example.com')
