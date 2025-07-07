USE leet_code;

CREATE TABLE Delivery
(
    delivery_id                 int,
    customer_id                 int,
    order_date                  date,
    customer_pref_delivery_date date
);

INSERT INTO Delivery (delivery_id, customer_id, order_date, customer_pref_delivery_date)
VALUES (1, 1, '2019-08-01', '2019-08-02'),
       (2, 2, '2019-08-02', '2019-08-02'),
       (3, 1, '2019-08-11', '2019-08-12'),
       (4, 3, '2019-08-24', '2019-08-24'),
       (5, 3, '2019-08-21', '2019-08-22'),
       (6, 2, '2019-08-11', '2019-08-13'),
       (7, 4, '2019-08-09', '2019-08-09');

-- IN 으로 결과셋 조회도 가능함.
SELECT
    ROUND(
            SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) * 100.0
                / COUNT(*),
            2
    ) AS immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date)
    FROM Delivery
    GROUP BY customer_id
);

--
SELECT
       ROUND((COUNT(IF(R.order_date = customer_pref_delivery_date, 1, null)) / COUNT(*)) * 100, 2) as immediate_percentage
FROM (SELECT *,
             DENSE_RANK() over (PARTITION BY customer_id ORDER BY order_date) as delivery_order_count
      FROM Delivery) AS R
WHERE R.delivery_order_count = 1

