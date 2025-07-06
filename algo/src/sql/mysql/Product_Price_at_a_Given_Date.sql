use leet_code;

CREATE TABLE Products (
    product_id int,
    new_price int,
    change_date date
);

INSERT INTO Products (product_id, new_price, change_date) VALUES
(1, 20, '2019-08-14'),
(2, 50, '2019-08-14'),
(1, 30, '2019-08-15'),
(1, 35, '2019-08-16'),
(2, 65, '2019-08-17'),
(3, 20, '2019-08-18');

WITH MaxProductDate as (
    SELECT product_id,
           MAX(change_date) as max_change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)
SELECT * FROM (
    SELECT
          A.product_id,
          A.new_price as price
    FROM Products A
    INNER JOIN MaxProductDate B
         ON A.product_id = B.product_id
        AND A.change_date = B.max_change_date
    UNION
    SELECT
        a.product_id,
         10 as price
    FROM Products A
    WHERE NOT EXISTS(
        SELECT * FROM MaxProductDate WHERE A.product_id = product_id
    )
) AS R
ORDER BY R.product_id;


-- 이게더 깔끔한거 같음. 컬럼을 한번 파티션 하는걸 생각해보자.
WITH cte AS
(SELECT *, RANK() OVER (PARTITION BY product_id ORDER BY change_date DESC) AS r
FROM Products
WHERE change_date<= '2019-08-16')

SELECT product_id, new_price AS price
FROM cte
WHERE r = 1
UNION
SELECT product_id, 10 AS price
FROM Products
WHERE product_id NOT IN (SELECT product_id FROM cte)