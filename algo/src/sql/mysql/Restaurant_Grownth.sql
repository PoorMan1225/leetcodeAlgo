USE leet_code;

CREATE TABLE RestaurantCustomer (
    customer_id int,
    name varchar(20),
    visited_on date,
    amount int
);

INSERT INTO RestaurantCustomer (customer_id, name, visited_on, amount) VALUES
(1, 'Jhon', '2019-01-01', 100),
(2, 'Daniel', '2019-01-02', 110),
(3, 'Jade', '2019-01-03', 120),
(4, 'Khaled', '2019-01-04', 130),
(5, 'Winston', '2019-01-05', 110),
(6, 'Elvis', '2019-01-06', 140),
(7, 'Anna', '2019-01-07', 150),
(8, 'Maria', '2019-01-08', 80),
(9, 'Jaze', '2019-01-09', 110),
(1, 'Jhon', '2019-01-10', 130),
(3, 'Jade', '2019-01-10', 150);


SELECT
    A.visited_on AS visited_on,
    SUM(B.amount) AS amount,
    ROUND(SUM(B.amount) / COUNT(DISTINCT B.visited_on), 2) AS average_amount
FROM (
         SELECT DISTINCT visited_on
         FROM RestaurantCustomer
     ) AS A
         JOIN RestaurantCustomer AS B
              ON B.visited_on BETWEEN DATE_SUB(A.visited_on, INTERVAL 6 DAY) AND A.visited_on
GROUP BY A.visited_on
HAVING COUNT(DISTINCT B.visited_on) = 7
ORDER BY A.visited_on;
