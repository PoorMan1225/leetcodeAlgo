USE leet_code;

CREATE TABLE ActorDirector (
    actor_id int,
    director_id int,
    timestamp int
);

INSERT INTO ActorDirector (actor_id, director_id, timestamp) VALUES
(1,1,0),
(1,1,1),
(1,1,2),
(1,2,3),
(1,2,4),
(2,1,5),
(2,1,6);

SELECT actor_id, director_id FROM ActorDirector GROUP BY actor_id, director_id
HAVING count(*) >= 3