use leet_code;


CREATE TABLE Seat (
    id int primary key auto_increment,
    student varchar(30)
);

INSERT INTO Seat (student) VALUES
('Abbot'),
('Doris'),
('Emerson'),
('Green'),
('Jeames');

-- next, prev 값을 구해서 다음행을 주던가 이전행을 주던가 결정 .
SELECT IF(MOD(R.id, 2) = 1,
          IF(next is null, R.id, next),
          prev
       ) as id,
       student
FROM (
    SELECT id,
           student,
           LEAD(id) over (ORDER BY id) as next,
           LAG(id) over (ORDER BY id) as prev
    FROM Seat
) AS R
ORDER BY id;

-- wow ! rownumber 를 아디로 따로줄 생각을 못햇네 대박
SELECT
    ROW_NUMBER() OVER(ORDER BY IF(MOD(id, 2) = 0, id - 1, id + 1)) AS id,
    student
FROM Seat;


