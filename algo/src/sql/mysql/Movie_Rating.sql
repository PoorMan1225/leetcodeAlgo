use leet_code;

CREATE TABLE Movies
(
    movie_id int,
    title    varchar(20)
);

INSERT INTO Movies (movie_id, title)
VALUES (1, 'Avengers'),
       (2, 'Frozen 2'),
       (3, 'Joker');

CREATE TABLE MovieUsers
(
    user_id int,
    name    varchar(20)
);

INSERT INTO MovieUsers (user_id, name)
VALUES (1, 'Daniel'),
       (2, 'Monica'),
       (3, 'Maria'),
       (4, 'James');

CREATE TABLE MovieRating
(
    movie_id   int,
    user_id    int,
    rating     int,
    created_at date
);

INSERT INTO MovieRating (movie_id, user_id, rating, created_at)
VALUES (1, 1, 3, '2020-01-12'),
       (1, 2, 4, '2020-02-11'),
       (1, 3, 2, '2020-02-12'),
       (1, 4, 1, '2020-01-01'),
       (2, 1, 5, '2020-02-17'),
       (2, 2, 2, '2020-02-01'),
       (2, 3, 2, '2020-03-01'),
       (3, 1, 3, '2020-02-22'),
       (3, 2, 4, '2020-02-25');

-- 가장 많은 수의 영화를 평가한 사용자의 이름 오름차순으로 정렬

SELECT results
FROM (
     SELECT name as results,
            count(*) as cnt
      FROM MovieUsers AS A
      INNER JOIN MovieRating AS B
         ON A.user_id = B.user_id
      GROUP BY B.user_id, A.name
      ORDER BY cnt desc, A.name
      LIMIT 1
) AS A
UNION ALL
-- february 2020 에서 평균 등급이 가장 높은 영화 이름 등급이 같을 경우 사전순 첫번째
SELECT results
FROM (
      SELECT
          A.title AS results,
          avg(B.rating) AS avg
      FROM Movies AS A
      INNER JOIN MovieRating AS B
         ON A.movie_id = B.movie_id
      WHERE YEAR(B.created_at) = '2020'
        AND MONTH(B.created_at) = 2
      GROUP BY B.movie_id, A.title
      ORDER BY avg desc, A.title
      LIMIT 1
) AS B
