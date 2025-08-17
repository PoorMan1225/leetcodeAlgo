CREATE TABLE Products (
    product_id int primary key ,
    product_name varchar(20),
    product_category varchar(20)
);

CREATE SEQUENCE SEQ_PRODUCTS
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE OR REPLACE TRIGGER TRG_PRODUCTS
    BEFORE INSERT ON Products
    FOR EACH ROW
BEGIN
    :NEW.product_id := SEQ_PRODUCTS.NEXTVAL;
END;

CREATE TABLE Orders (
    product_id int,
    order_date date,
    unit int,
    constraint fk_Orders FOREIGN KEY (product_id)
                    REFERENCES PRODUCTS(product_id)
);

-- 오라클은 한번에 삽입이 불가능합니당.
INSERT INTO Products (product_name, product_category) VALUES ('Leetcode Solutions', 'Book');
INSERT INTO Products (product_name, product_category) VALUES ('Jewels of Stringology', 'Book');
INSERT INTO Products (product_name, product_category) VALUES ('HP', 'Laptop');
INSERT INTO Products (product_name, product_category) VALUES ('Lenovo', 'Laptop');
INSERT INTO Products (product_name, product_category) VALUES ('Leetcode Kit', 'T-shirt');


INSERT INTO Orders (product_id, order_date, unit) VALUES (1, '2020-02-05', 60);
INSERT INTO Orders (product_id, order_date, unit) VALUES (1, '2020-02-10', 70);
INSERT INTO Orders (product_id, order_date, unit) VALUES (2, '2020-01-18', 30);
INSERT INTO Orders (product_id, order_date, unit) VALUES (2, '2020-02-11', 80);
INSERT INTO Orders (product_id, order_date, unit) VALUES (3, '2020-02-17', 2);
INSERT INTO Orders (product_id, order_date, unit) VALUES (3, '2020-02-24', 3);
INSERT INTO Orders (product_id, order_date, unit) VALUES (4, '2020-03-01', 20);
INSERT INTO Orders (product_id, order_date, unit) VALUES (4, '2020-03-04', 30);
INSERT INTO Orders (product_id, order_date, unit) VALUES (4, '2020-03-04', 60);
INSERT INTO Orders (product_id, order_date, unit) VALUES (5, '2020-02-25', 50);
INSERT INTO Orders (product_id, order_date, unit) VALUES (5, '2020-02-27', 50);
INSERT INTO Orders (product_id, order_date, unit) VALUES (5, '2020-03-01', 50);


-- 2020년 2월에 최소 100단위를 주문한 제품 이름과 금액
SELECT B.product_name,
       SUM(A.UNIT) AS unit
FROM Orders A
INNER JOIN Products B
    ON A.product_id = B.product_id
WHERE TO_CHAR(A.ORDER_DATE, 'YYYY') = '2020'
    AND TO_CHAR(A.ORDER_DATE, 'MM') = '02'
GROUP BY A.product_id, B.product_name
HAVING SUM(A.UNIT) >= 100
