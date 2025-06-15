use leet_code;

-- 연속적으로 세번이상 나타나는 숫자 찾기
CREATE TABLE Logs
(
    id  int primary key auto_increment,
    num varchar(10)
);

insert into Logs (num) value
    (1),
    (1),
    (1),
    (2),
    (1),
    (2)
;

-- 1. 먼저 셀레트해서 정보를 가지고 온다.
-- 2. 가지고온 정보를 토대로 그룹핑한 결과를 만들어준다.
SELECT num as ConsecutiveNums
FROM (SELECT id,
             num,
             -- mysql 에서는 변수 선언안하고 암묵적으로 가능함 SELECT @VALUE := 1 과 같음
             -- 다른 Sql 에서는 변수를 선언해야 할 필요가 있음.
             @count := IF(@prev = num, @count + 1, 1) as count,
             @prev := IF(num != @prev, num, @prev)    as grp
      FROM Logs
      ORDER BY id) AS count_grp
WHERE count >= 3;

-- 3개 테이블의 교차 인덱스를 가져오는 방법
-- 논리적으로 생각해볼때 세개의 값을 찾아오는 것은 123 행 값이 모두 같은 행을 가져오면 된다.
SELECT DISTINCT num
FROM (SELECT num,
             LEAD(num, 1) OVER (ORDER BY id) AS next1, -- LEAD 함수는 현재 행에서 다음 offset 행을 볼 수 있게 해준다 (MySql 8.0) 부터 사용 가능하다.
             LEAD(num, 2) OVER (ORDER BY id) AS next2
      FROM Logs) AS t
WHERE num = next1
  AND num = next2;


-- 좀더 일반적인 조인 방법
SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1,
     Logs l2,
     Logs l3
WHERE l1.num = l2.num
  AND l2.num = l3.num
  AND l1.id = l2.id - 1
  AND l2.id = l3.id - 1;
