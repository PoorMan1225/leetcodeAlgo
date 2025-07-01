USE leet_code;

CREATE TABLE Customer (
    customer_id int,
    product_key int
);

INSERT INTO Customer (customer_id, product_key) VALUES
(1, 5),
(2, 6),
(3, 5),
(3, 6),
(1, 6);

CREATE TABLE Product (
    product_key int primary key
);

INSERT INTO Product (product_key) VALUES
(5),
(6);


WITH ProductKey AS (
    SELECT
        COUNT(*) as cnt_prd
    FROM Product
)

SELECT
    customer_id,
    COUNT(distinct product_key) as cnt_cust  -- 같은 제품을 여러번 샀을 수 도 있따.
FROM Customer GROUP BY customer_id
HAVING cnt_cust = (SELECT * FROM ProductKey)




