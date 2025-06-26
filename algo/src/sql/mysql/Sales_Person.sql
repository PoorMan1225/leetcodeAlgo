USE leet_code;

CREATE TABLE SalesPerson (
    sales_id int primary key auto_increment,
    name varchar(20),
    salary int,
    commission_rate int,
    hire_date varchar(10)
);


INSERT INTO SalesPerson (name, salary, commission_rate, hire_date) VALUES
('John', 100000, 6, '4/1/2006'),
('Amy', 12000, 5, '5/1/2010'),
('Mark', 65000, 13, '12/25/2008'),
('Pam', 25000, 25, '1/1/2005'),
('Alex', 5000, 10, '2/3/2007');

CREATE TABLE Company (
    com_id int primary key auto_increment,
    name varchar(20),
    city varchar(20)
);

INSERT INTO Company (name, city) VALUES
('RED', 'Boston'),
('ORANGE', 'New York'),
('YELLOW', 'Boston'),
('GREEN', 'Austin');

CREATE TABLE __Orders (
    order_id int primary key auto_increment,
    order_date varchar(10),
    com_id int,
    sales_id int,
    amount int
);

INSERT INTO __Orders (order_date, com_id, sales_id, amount) VALUES
('1/1/2014', 3, 4, 10000),
('2/1/2014', 4, 5, 5000),
('3/1/2014', 1, 1, 50000),
('4/1/2014', 1, 4, 25000);

-- red 회사에 영업한 사원 아이디
WITH RedContainsSalesPerson AS (
    SELECT A.sales_id FROM SalesPerson AS A
    INNER JOIN __Orders AS B
    ON A.sales_id = B.sales_id
    INNER JOIN Company AS C
    ON B.com_id = C.com_id
    WHERE C.name = 'RED'
    GROUP BY A.sales_id
)
-- IN 은 보통 결과셋이 작을때 사용.
SELECT name FROM SalesPerson AS A
WHERE NOT EXISTS(
    SELECT sales_id
    FROM RedContainsSalesPerson
    WHERE sales_id = A.sales_id
)




