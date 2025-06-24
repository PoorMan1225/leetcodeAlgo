USE leet_code;

CREATE TABLE _Orders
(
    order_number    int primary key auto_increment,
    customer_number int
);

INSERT INTO _Orders (customer_number)
VALUES (1),
       (2),
       (3),
       (3);

SELECT customer_number
FROM _Orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1


