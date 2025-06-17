USE leet_code;


CREATE TABLE Customers (
    id int primary key auto_increment,
    name varchar(30)
);

CREATE TABLE Orders(
    id int primary key auto_increment,
    customerId int,
    foreign key (customerId) references Customers(id)
);

INSERT INTO Customers (name) VALUES
('Joe'),
('Henry'),
('Sam'),
('Max');

INSERT INTO Orders (customerId) VALUES
(3),
(1);

SELECT name AS Customers FROM Customers AS A
LEFT JOIN Orders O on A.id = O.customerId
WHERE O.id IS NULL




