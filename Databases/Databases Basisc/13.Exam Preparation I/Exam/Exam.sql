CREATE DATABASE my_airport;
USE my_airport;

-- 1.Problem
CREATE TABLE towns(
	town_id INT PRIMARY KEY ,
	town_name VARCHAR(30) NOT NULL
);

CREATE TABLE airports(
	airport_id INT PRIMARY KEY ,
	airport_name VARCHAR(50) NOT NULL,
	town_id INT,
	CONSTRAINT fk_airport_town FOREIGN KEY(town_id)
	REFERENCES towns(town_id)
);


CREATE TABLE airlines(
	airline_id INT PRIMARY KEY,
	airline_name VARCHAR(30) NOT NULL,
	nationality VARCHAR(30) NOT NULL,
	rating INT DEFAULT 0
);

CREATE TABLE customers(
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	date_of_birth DATE NOT NULL,
	gender VARCHAR(1),
	home_town_id INT,
	CONSTRAINT fk_customer_town FOREIGN KEY(home_town_id)
	REFERENCES towns(town_id),
	CONSTRAINT check_gener CHECK (gender IN ('M','F'))
);

CREATE TABLE flights(
	flight_id INT PRIMARY KEY AUTO_INCREMENT,
	departure_time DATETIME NOT NULL,
	arrival_time DATETIME NOT NULL,
	`status` VARCHAR(9),
	origin_airport_id INT,
	destination_airport_id INT,
	airline_id INT,
	CONSTRAINT check_status
	CHECK (`status` IN ('Departing','Delayed','Arrived', 'Cancelled')),
	CONSTRAINT fk_flight_orig_airport FOREIGN KEY(origin_airport_id) REFERENCES airports(airport_id),
	CONSTRAINT fk_flight_dest_airport FOREIGN KEY(
	destination_airport_id) REFERENCES airports(airport_id),
	CONSTRAINT fk_flight_airline FOREIGN KEY(airline_id)
	REFERENCES airlines(airline_id)
);

CREATE TABLE tickets(
	ticket_id INT PRIMARY KEY AUTO_INCREMENT,
	price DECIMAL(8,2) NOT NULL,
	class VARCHAR(6),
	seat VARCHAR(5) NOT NULL,
	customer_id INT,
	flight_id INT,
	CONSTRAINT check_class CHECK (class IN ('First','Second','Third')),
	CONSTRAINT fk_ticket_customer FOREIGN KEY(customer_id)
	REFERENCES customers(customer_id),
	CONSTRAINT fk_ticket_flight FOREIGN KEY(flight_id)
	REFERENCES flights(flight_id)
);


-- 2.Problem
INSERT INTO flights(departure_time,arrival_time,`status`,origin_airport_id,destination_airport_id,airline_id)
	VALUES
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 1 % 4 = 0 THEN 'Departing'
		WHEN 1 % 4 = 1 THEN 'Delayed'
		WHEN 1 % 4 = 2 THEN 'Arrived'
		WHEN 1 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 1)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 1)))),
	1),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 2 % 4 = 0 THEN 'Departing'
		WHEN 2 % 4 = 1 THEN 'Delayed'
		WHEN 2 % 4 = 2 THEN 'Arrived'
		WHEN 2 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 2)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 2)))),
	2),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 3 % 4 = 0 THEN 'Departing'
		WHEN 3 % 4 = 1 THEN 'Delayed'
		WHEN 3 % 4 = 2 THEN 'Arrived'
		WHEN 3 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 3)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 3)))),
	3),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 4 % 4 = 0 THEN 'Departing'
		WHEN 4 % 4 = 1 THEN 'Delayed'
		WHEN 4 % 4 = 2 THEN 'Arrived'
		WHEN 4 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 4)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 4)))),
	4),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 5 % 4 = 0 THEN 'Departing'
		WHEN 5 % 4 = 1 THEN 'Delayed'
		WHEN 5 % 4 = 2 THEN 'Arrived'
		WHEN 5 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 5)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 5)))),
	5),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 6 % 4 = 0 THEN 'Departing'
		WHEN 6 % 4 = 1 THEN 'Delayed'
		WHEN 6 % 4 = 2 THEN 'Arrived'
		WHEN 6 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 6)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 6)))),
	6),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 7 % 4 = 0 THEN 'Departing'
		WHEN 7 % 4 = 1 THEN 'Delayed'
		WHEN 7 % 4 = 2 THEN 'Arrived'
		WHEN 7 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 7)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 7)))),
	7),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 8 % 4 = 0 THEN 'Departing'
		WHEN 8 % 4 = 1 THEN 'Delayed'
		WHEN 8 % 4 = 2 THEN 'Arrived'
		WHEN 8 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 8)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 8)))),
	8),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 9 % 4 = 0 THEN 'Departing'
		WHEN 9 % 4 = 1 THEN 'Delayed'
		WHEN 9 % 4 = 2 THEN 'Arrived'
		WHEN 9 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 9)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 9)))),
	9),
	
	('2017-06-19 14:00:00','2017-06-21 11:00:00',
	CASE 
		WHEN 10 % 4 = 0 THEN 'Departing'
		WHEN 10 % 4 = 1 THEN 'Delayed'
		WHEN 10 % 4 = 2 THEN 'Arrived'
		WHEN 10 % 4 = 3 THEN 'Canceled'
	END, 
	CEILING(SQRT(CHAR_LENGTH((SELECT a.airline_name FROM airlines AS a WHERE a.airline_id = 10)))),
	CEILING(SQRT(CHAR_LENGTH((SELECT a.nationality FROM airlines AS a WHERE a.airline_id = 10)))),
	10);
	
	
-- 3.Problem
UPDATE flights 
SET flights.airline_id = 1 
WHERE flights.`status` = 'Arrived';

-- 4.Problem
UPDATE tickets AS t
	INNER JOIN flights AS f
	ON t.flight_id = f.flight_id
		INNER JOIN airlines AS a
		ON a.airline_id = f.airline_id
SET t.price = t.price/2
	WHERE a.rating = (SELECT a.airline_id
	FROM airlines AS a
ORDER BY a.rating DESC LIMIT 1);

-- 5.Problem
SELECT t.ticket_id, t.price, t.class, t.seat
FROM tickets AS t
ORDER BY t.ticket_id;

-- 6.Problem
SELECT c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS 'full_name',c.gender
FROM customers AS c
ORDER BY `full_name`,c.customer_id;

-- 7.Problem
SELECT f.flight_id, f.departure_time, f.arrival_time
FROM flights AS f
WHERE f.`status` = 'Delayed'
ORDER BY f.flight_id;

-- 8.Problem
SELECT DISTINCT a.airline_id,a.airline_name,a.nationality,a.rating
FROM airlines AS a
INNER JOIN flights AS f
ON f.airline_id = a.airline_id
ORDER BY a.rating DESC LIMIT 5;

-- 9.Problem
SELECT t.ticket_id,ap.airport_name AS 'destination',CONCAT(c.first_name,' ',c.last_name) AS 'customer_name'
FROM tickets AS t
INNER JOIN flights AS f
ON t.flight_id = f.flight_id
INNER JOIN customers AS c
ON c.customer_id = t.customer_id
INNER JOIN airports AS ap
ON f.destination_airport_id = ap.airport_id
AND t.price < 5000
AND t.class = 'First'
ORDER BY t.ticket_id;

-- 10.Problem
SELECT DISTINCT c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS 'full_name',t.town_name AS 'home_town'
FROM customers AS c

INNER JOIN towns AS t
ON c.home_town_id = t.town_id

INNER JOIN tickets AS tc
ON tc.customer_id = c.customer_id

INNER JOIN flights AS f
ON f.flight_id = tc.flight_id
AND f.`status` = 'Departing'

INNER JOIN airports AS ap
ON ap.town_id = c.home_town_id
AND f.origin_airport_id = ap.airport_id

ORDER BY c.customer_id;

-- 11.Problem

SELECT DISTINCT c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS 'full_name', (2016- YEAR(c.date_of_birth)) AS 'age'
FROM customers AS c
INNER JOIN tickets AS t
ON t.customer_id = c.customer_id
INNER JOIN flights AS f
ON t.flight_id = f.flight_id
AND f.`status` = 'Departing'
ORDER BY `age`,c.customer_id;


-- 12.Problem
SELECT DISTINCT c.customer_id, CONCAT(c.first_name,' ',c.last_name) AS 'full_name', t.price AS 'ticket_price', ap.airport_name AS 'destination'
FROM customers AS c
INNER JOIN tickets AS t
ON c.customer_id = t.customer_id
INNER JOIN flights AS f
ON f.flight_id = t.flight_id
AND f.`status` = 'Delayed'
INNER JOIN airports AS ap
ON ap.airport_id = f.destination_airport_id
ORDER BY t.price DESC,c.customer_id LIMIT 3;


-- 13.Problem
SELECT f.flight_id, f.departure_time, f.arrival_time, 
FROM flights AS f