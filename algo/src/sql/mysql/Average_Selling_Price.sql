use leet_code;

CREATE TABLE Prices (
    product_id int,
    start_date date,
    end_date date,
    price int
);

CREATE TABLE UnitsSold (
    product_id int,
    purchase_date date,
    units int
);

INSERT INTO Prices (product_id, start_date, end_date, price) VALUES
(1, '2019-02-17', '2019-02-28', 5),
(1, '2019-03-01', '2019-03-22', 20),
(2, '2019-02-01', '2019-02-20', 15),
(2, '2019-02-21', '2019-03-31', 30);

delete from unitssold where  1=1;

INSERT INTO UnitsSold (product_id, purchase_date, units) VALUES
(1, '2019-02-25', 100),
(1, '2019-03-01', 15),
(2, '2019-02-10', 200),
(2, '2019-03-22', 30);


-- 가격 테이블과 UnitsSold 테이블을 조인해보자.
-- 0/0 무조건 0으로 나누면 오류 아니면 null 이다 알겟냐!
SELECT A.product_id,
       ifnull(round(sum(price * units) / sum(units), 2), 0) as average_price
FROM Prices AS A
LEFT JOIN UnitsSold AS B
ON A.product_id = B.product_id
AND A.start_date <= B.purchase_date
AND A.end_date >= B.purchase_date
GROUP BY A.product_id;
