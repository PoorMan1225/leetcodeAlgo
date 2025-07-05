use leet_code;

CREATE TABLE PUsers (
    user_id int,
    join_date date,
    favorite_brand varchar(20)
);

CREATE TABLE POrders (
    order_id int,
    order_date date ,
    item_id int,
    buyer_id int,
    seller_id int
);

CREATE TABLE PItems (
    item_id int,
    item_brand varchar(20)
);

INSERT INTO PUsers (user_id, join_date, favorite_brand) VALUES
(1, '2018-01-01', 'Lenovo'),
(2, '2018-02-09', 'Samsung'),
(3, '2018-01-19', 'LG'),
(4, '2018-05-21', 'HP');


INSERT INTO POrders (order_id, order_date, item_id, buyer_id, seller_id) VALUES
(1, '2019-08-01', 4, 1, 2),
(2, '2018-08-02', 2, 1, 3),
(3, '2019-08-03', 3, 2, 3),
(4, '2018-08-04', 1, 4, 2),
(5, '2018-08-04', 1, 3, 4),
(6, '2019-08-05', 2, 2, 4);

INSERT INTO PItems (item_id, item_brand) VALUES
(1, 'Samsung'),
(2, 'Lenovo'),
(3, 'LG'),
(4, 'HP');

-- 사용자 전체 에서 2019 년도에 구매한 구매갯수를 보여주는 쿼리를 작성하라.
SELECT
    user_id as buyer_id,
    join_date,
    count(b.order_id) as orders_in_2019
FROM PUsers AS A
LEFT JOIN POrders AS B
ON A.user_id = B.buyer_id
AND YEAR(order_date) = '2019'
GROUP BY user_id, join_date