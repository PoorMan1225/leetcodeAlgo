USE leet_code;

CREATE TABLE Trips
(
    id         int auto_increment primary key,
    client_id  int,
    driver_id  int,
    city_id    int,
    status     varchar(30),
    request_at varchar(10),
    foreign key (driver_id, client_id) references Users (users_id)
);

CREATE TABLE Users
(
    users_id int primary key,
    banned   varchar(20),
    role     varchar(10)
);

INSERT INTO Trips (client_id, driver_id, city_id, status, request_at)
VALUES (1, 10, 1, 'completed', '2013-10-01'),
       (2, 11, 1, 'cancelled_by_driver', '2013-10-01'),
       (3, 12, 6, 'completed', '2013-10-01'),
       (4, 13, 6, 'cancelled_by_client', '2013-10-01'),
       (1, 10, 1, 'completed', '2013-10-02'),
       (2, 11, 6, 'completed', '2013-10-02'),
       (3, 12, 6, 'completed', '2013-10-02'),
       (2, 12, 12, 'completed', '2013-10-03'),
       (3, 10, 12, 'completed', '2013-10-03'),
       (4, 13, 12, 'cancelled_by_driver', '2013-10-03');

INSERT INTO Users (users_id, banned, role)
VALUES (1, 'NO', 'client'),
       (2, 'YES', 'client'),
       (3, 'NO', 'client'),
       (4, 'NO', 'client'),
       (10, 'NO', 'driver'),
       (11, 'NO', 'driver'),
       (12, 'NO', 'driver'),
       (13, 'NO', 'driver');

SELECT R.Day,
       CAST((R.Cancel_Count / R.All_Count) AS DECIMAL(10, 2)) as Cancel_Rate
FROM (SELECT A.request_at                                AS Day,
             COUNT(*)                                    AS All_Count,
             COUNT(IF(A.status != 'completed', 1, NULL)) AS Cancel_Count -- COUNT 는 NULL 이 아닌값만 센다. 그래서 NULL 을 넣으면 안센다.
      FROM Trips A
               INNER JOIN Users B
                          ON A.client_id = B.users_id
                              AND B.banned = 'NO'
               INNER JOIN users C
                          ON A.driver_id = C.users_id
                              AND C.banned = 'NO'
      GROUP BY request_at) AS R





