USE leet_code;

CREATE TABLE Person
(
    id    int primary key auto_increment,
    email varchar(30)
);

INSERT INTO Person (email) VALUE
    ('a@b.com'),
    ('c@d.com'),
    ('a@b.com');

-- 중복 이메일맘 가져오기
WITH NUMBER AS (
    SELECT email, ROW_NUMBER() over (ORDER BY email) AS RN FROM Person ORDER BY email
)
SELECT DISTINCT A.email AS Email FROM NUMBER A
INNER JOIN NUMBER B
ON A.email = B.email
WHERE A.RN = B.RN - 1;

-- 걍 그룹바이 해서 Having 절로 끝내면 됨.
SELECT email FROM Person GROUP BY email
HAVING count(*) > 1