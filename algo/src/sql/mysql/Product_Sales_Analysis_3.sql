use leet_code;

-- 각 제품이 판매 된 첫 해에 발생한 모든 판매를 찾기 위한 솔루션
With MinProduct AS (
    SELECT product_id,
           MIN(year) as year
    FROM sales
    GROUP BY product_id
)
SELECT A.product_id,
       B.year as first_year,
       A.quantity,
       A.price FROM sales A
INNER JOIN MinProduct B
ON A.product_id = B.product_id
AND A.year = B.year;

-- dense rank 사용
WITH RankProduct AS (
    SELECT *,
           RANK() over (partition by product_id order by year) as rn
    FROM Sales
)
SELECT * FROM RankProduct WHERE rn = 1




