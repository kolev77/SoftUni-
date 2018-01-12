INSERT INTO employees(first_name,last_name,gender,birthdate,department_id)
VALUES ('Marlo',"O'Malley",'M','1958-9-21',1),
		 ('Niki','Stanaghan','f','1969-11-26',4),
		 ('Ayrton','Senna','M','1960-03-21',9),
		 ('Ronnie','Peterson','M','1944-02-14',9),
		 ('Giovanna','Amati','M','1959-07-20',5);


INSERT INTO reports(category_id,status_id,open_date,close_date,description,user_id,employee_id)
VALUES
	(1,1,'2017-04-13',NULL,'Stuck Road on Str.133',6,2),
	(6,3,'2015-09-05','2015-12-06','Charity trail running',3,5),
	(14,2,'2015-09-07',NULL,'Falling bricks on Str.58',5,2),
	(4,3,'2017-07-03','2017-07-06','Cut off streetlight on Str.11',1,1);
	
	
-- 3.Problem

UPDATE 
reports AS r
SET r.status_id = 2
WHERE r.status_id = 1
AND r.category_id = 4;


-- 4.Problem

DELETE FROM reports
WHERE status_id = 4;


-- 5.Problem

SELECT u.username,u.age
FROM users AS u 
ORDER BY u.age ASC,u.username DESC;


-- 6.Problem

SELECT r.description, r.open_date
FROM reports AS r
WHERE r.employee_id IS NULL
ORDER BY r.open_date, r.description;


-- 7.Problem

SELECT e.first_name, e.last_name, r.description, DATE_FORMAT(open_date,'%Y-%m-%d') AS 'open_date'
FROM employees AS e
INNER JOIN reports AS r
ON r.employee_id = e.id
ORDER BY e.id, r.open_date, r.id;


-- 8.Problem
SELECT c.name AS 'category_name', COUNT(r.category_id) AS 'reports_number'
FROM categories AS c
INNER JOIN reports AS r
ON c.id = r.category_id
GROUP BY c.name
ORDER BY `reports_number`,c.name;


-- 9.Problem
SELECT c.name AS 'category_name',COUNT(e.department_id) AS 'employees_number'
FROM categories AS c
INNER JOIN departments AS d
ON c.department_id = d.id
INNER JOIN employees AS e
ON e.department_id = d.id
AND d.id = c.department_id
GROUP BY c.name
ORDER BY c.name;

-- 10.Problem 
SELECT DISTINCT c.name
FROM categories AS c
INNER JOIN reports AS r
ON r.category_id = c.id
INNER JOIN users AS u
ON DATE_FORMAT(u.birthdate,'%m-%d') = DATE_FORMAT(r.open_date,'%m-%d') AND u.id = r.user_id
ORDER BY c.name;


-- 11.Problem
	SELECT CONCAT(e.first_name,' ',e.last_name) AS 'name',COUNT(r.user_id) AS 'users_count'
	FROM employees AS e
	LEFT OUTER JOIN reports AS r
	ON e.id = r.employee_id
	AND (r.user_id IN (SELECT DISTINCT r.user_id
	FROM reports AS r) OR r.User_Id )
	GROUP BY `name`
	ORDER BY `users_count`DESC,`name`;
	
	
-- 12.Problem

SELECT r.open_date, r.description, u.email AS 'reporter_email'
FROM reports AS r
INNER JOIN users AS u
ON r.user_id = u.id AND 
r.close_date IS NULL AND
r.description LIKE '%str%'
AND CHAR_LENGTH(r.description) > 20
INNER JOIN categories AS c
ON c.id = r.category_id
INNER JOIN departments AS d
ON d.id = c.department_id
ORDER BY r.open_date, u.email, r.id;


-- 13.Problem
SELECT u.username
FROM users AS u
WHERE u.username regexp '^[0-9]+'
OR u.username regexp '[0-9]$';


-- 14.Problem
SELECT CONCAT(e.first_name,' ',e.last_name) as 'name',CONCAT(b.closed_reports,'/',(COUNT(r.open_date))) AS 'closed_open_reports'
FROM employees AS e,(SELECT e.id,COUNT(r.close_date) AS 'closed_reports'
		FROM employees AS e
		 JOIN reports AS r
		ON e.id = r.employee_id
		AND r.close_date IS NOT NULL
		GROUP BY e.id) AS 'b'
INNER JOIN b
		ON e.id = b.id;
	
	
SELECT CONCAT(e.first_name,' ',e.last_name) as 'name',CONCAT(b.closed_reports,'/',c.open_reports) AS 'closed_open_reports'
FROM employees AS e
INNER JOIN
	(SELECT e.id AS 'id',COUNT(r.close_date) AS 'closed_reports'
			FROM employees AS e
			LEFT OUTER JOIN reports AS r
			ON e.id = r.employee_id
			AND r.close_date IS NOT NULL
			GROUP BY e.id) as b
ON e.id = b.id
INNER JOIN (SELECT e.id AS 'id',COUNT(r.open_date) AS 'open_reports'
			FROM employees AS e
			LEFT OUTER JOIN reports AS r
			ON e.id = r.employee_id
			AND YEAR(r.open_date) < YEAR(2016)
			GROUP BY e.id) AS c
			ON c.id = e.id
			ORDER BY `name`;



-- 19.

DELIMITER $$
CREATE TRIGGER `tr_update_flights`
AFTER UPDATE 
ON reports FOR EACH ROW
BEGIN
	IF (new.close_date != old.close_date)
	THEN
	UPDATE reports AS r
	SET r.status_id = 3;
	END IF;
END$$
	
	
SELECT s.id FROM `status` AS s WHERE s.label = 'completed';


-- 18

 DROP procedure usp_assign_employee_to_report ;
DELIMITER $$
CREATE PROCEDURE usp_assign_employee_to_report(IN employee_id INT, IN report_id INT)
BEGIN
	IF(SELECT e.id FROM employees AS e
	INNER JOIN categories AS c
	ON c.id = d.id 
	INNER JOIN reports AS r
	ON r.id = 
	WHERE e.id = employee_id
	AND r.category_id = e.department_id)
	THEN 
		UPDATE reports AS r
		SET r.employee_id := employee_id
		WHERE r.id = report_id;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Employee doesn't belong to the appropriate department!";
		ROLLBACK;
	END IF;				
END$$

usp_assign_employee_to_report(

