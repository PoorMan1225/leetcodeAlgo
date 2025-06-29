use leet_code;

CREATE TABLE Cinema (
    id int primary key auto_increment,
    movie varchar(20),
    description varchar(100),
    rating float
);

INSERT INTO Cinema (movie, description, rating) VALUES
('War', 'great 3D', 8.9),
('Science', 'fiction', 8.9),
('irish', 'boring', 8.9),
('Ics song', 'Fantacy', 8.9),
('House card', 'Interesting', 8.9);


SELECT * FROM Cinema
WHERE MOD(id, 2) = 1
AND description != 'boring'
ORDER BY rating DESC