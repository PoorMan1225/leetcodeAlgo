USE leet_code;


CREATE TABLE Insurance
(
    pid      int auto_increment primary key,
    tiv_2015 float,
    tiv_2016 float,
    lat      float,
    lon      float
);

INSERT INTO Insurance (tiv_2015, tiv_2016, lat, lon)
VALUES (10, 5, 10, 10),
       (20, 20, 20, 20),
       (10, 30, 20, 20),
       (10, 40, 40, 40);

-- NOT IN 은 NULL 문제가 있어서 사용하기 안좋다. 그래서 NOT EXSISTS 를 사용해야 한다.
select round(sum(tiv_2016),2) as tiv_2016
from insurance
where tiv_2015 in(
    select tiv_2015 from insurance
    group by tiv_2015
    having count(*) >1
)
  -- 두개 컬럼 동시 비교 거의 모두 지원되긴 하지만 이게 안된다면 CONCAT 으로 억지로 붙이고 비교해야 한다.
  -- 두개 컬럼 동시 비교 문법을 사용하려면 반드시 리턴이 두개 컬럼이어야 한다.
  and (lat,lon ) in(
    select lat,lon from insurance
    group by lat,lon
    having count(*)=1
);



