CREATE TABLE Stocks(
    stock_name varchar(20),
    operation varchar(20) check (operation in ('Sell', 'Buy')),
    operation_day int,
    price int
);

INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Leetcode', 'Buy', 1, 1000);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Buy', 2, 10);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Buy', 3, 10);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Leetcode', 'Sell', 5, 9000);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Handbags', 'Buy', 17, 30000);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Sell', 3, 1010);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Buy', 4, 1000);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Sell', 5, 500);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Buy', 6, 1000);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Handbags', 'Sell', 29, 7000);
INSERT INTO Stocks (stock_name, operation, operation_day, price) VALUES ('Corona Masks', 'Sell', 10, 10000);

-- 먼저 스탁스를 정렬을 한다.
WITH StockInfo AS (
    SELECT S.*,
           SUM(CASE WHEN operation = 'Sell' THEN 1 ELSE 0 END)
               OVER (PARTITION BY stock_name ORDER BY operation_day
                   -- 각행에서 몇번 Sell 이 나왔는지 카운트
                   -- 현재 행부터 끝행까지의 카운트 행을 세는 것
                   ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS grp
    FROM STOCKS S
)
SELECT stock_name,
       SUM(
               CASE WHEN operation = 'Sell' THEN price ELSE 0 END
                   - CASE WHEN operation = 'Buy' THEN price ELSE 0 END
       ) AS capital_gain_loss
FROM StockInfo
GROUP BY stock_name;



