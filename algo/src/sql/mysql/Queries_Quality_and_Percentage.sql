USE leet_code;

CREATE TABLE Queries (
    query_name varchar(20),
    result varchar(20),
    position int,
    rating int
);

INSERT INTO Queries (query_name, result, position, rating) VALUES
('Dog', 'Golden Retriever', 1, 5),
('Dog', 'German Shepherd', 2, 5),
('Dog', 'Mule', 200, 1),
('Cat', 'Shirazi', 5, 2),
('Cat', 'Siamese', 3, 3),
('Cat', 'Sphynx', 7, 4);

SELECT query_name,
       round(sum(rating / position) / count(*), 2) as quality,
       round((count(if(rating < 3, 1, null)) / count(*)) * 100, 2) as poor_query_percentage
FROM Queries
GROUP BY query_name
