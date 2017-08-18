-- Innner JOIN 
SELECT * FROM employees as e 
INNER JOIN departments AS d
ON e.department_id = d.department_id;

-- LEFT OUTER JOIN
-- Left table (first), Right table(second)
SELECT * FROM employees AS e
LEFT OUTER JOIN departments AS d
ON e.department_id = d.department_id;

-- FULL JOIN 
SELECT * FROM employees AS e
LEFT OUTER JOIN departments AS d
ON e.department_id = d.department_id
UNION
SELECT * FROM employees AS e
RIGHT OUTER JOIN departments AS d
ON e.department_id = d.department_id;

-- CROSS JOIN  - join all elements 
CREATE TABLE cross_test ( 
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    num INT );

USE `cross_test`;

INSERT INTO cross_test(num)
VALUES (1),(2),(3),(4);

SELECT * FROM cross_test
CROSS JOIN cross_test AS ct;

