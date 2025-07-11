USE leet_code;

CREATE TABLE Transactions
(
    id         int primary key,
    country    varchar(20),
    state      enum ('approved', 'declined'),
    amount     int,
    trans_date date
);

INSERT INTO Transactions (id, country, state, amount, trans_date)
VALUES (121, 'US', 'approved', 1000, '2018-12-18'),
       (122, 'US', 'declined', 2000, '2018-12-19'),
       (123, 'US', 'approved', 2000, '2019-01-01'),
       (124, 'DE', 'approved', 2000, '2019-01-07');

SELECT
    DATE_FORMAT(trans_date, '%Y-%m') as month,
    country,
    count(*) as trans_count,
    count(case when state = 'approved' then 1 end) as approved_count,
    sum(amount) as trans_total_amount,
    sum(if(state = 'approved', amount, 0)) as approved_total_amount
FROM Transactions
GROUP BY month, country
