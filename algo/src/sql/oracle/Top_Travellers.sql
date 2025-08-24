CREATE TABLE USERS
(
    id   int primary key,
    name varchar(20)
);

INSERT INTO USERS (id, name) VALUES (1, 'Alice');
INSERT INTO USERS (id, name) VALUES (2, 'Bob');
INSERT INTO USERS (id, name) VALUES (3, 'Alex');
INSERT INTO USERS (id, name) VALUES (4, 'Donald');
INSERT INTO USERS (id, name) VALUES (7, 'Lee');
INSERT INTO USERS (id, name) VALUES (13, 'Jonathan');
INSERT INTO USERS (id, name) VALUES (19, 'Elvis');

CREATE TABLE RIDES (
    id int primary key,
    user_id int,
    distance int
);

INSERT INTO RIDES (id, user_id, distance) VALUES (1, 1, 120);
INSERT INTO RIDES (id, user_id, distance) VALUES (2, 2, 317);
INSERT INTO RIDES (id, user_id, distance) VALUES (3, 3, 222);
INSERT INTO RIDES (id, user_id, distance) VALUES (4, 7, 100);
INSERT INTO RIDES (id, user_id, distance) VALUES (5, 13, 312);
INSERT INTO RIDES (id, user_id, distance) VALUES (6, 19, 50);
INSERT INTO RIDES (id, user_id, distance) VALUES (7, 7, 120);
INSERT INTO RIDES (id, user_id, distance) VALUES (8, 19, 400);
INSERT INTO RIDES (id, user_id, distance) VALUES (9, 7, 230);


SELECT R.name,
       SUM(NVL(R.distance, 0)) as travelled_distance
FROM (
SELECT A.id, name, distance FROM USERS A
LEFT JOIN RIDES B
ON A.ID = B.USER_ID) R
GROUP BY R.id, R.name
ORDER BY SUM(NVL(R.distance, 0)) DESC , R.name




