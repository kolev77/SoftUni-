USE soft_uni;

-- Join
SELECT *
FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
LIMIT 5;

-- Inner Join - A join of two tables returning only rows matching the join condition
SELECT *
FROM employees AS e
INNER JOIN departments AS d ON e.department_id = d.department_id;

-- Left Outer Join -Returns the results of the inner join as well as unmatched rows from the right table
SELECT *
FROM employees AS e
LEFT OUTER
JOIN departments AS d ON e.department_id = d.department_id AND e.employee_id = 2;
 
-- Right Outer Join - -Returns the results of the inner join as well as unmatched rows from the left table
SELECT *
FROM employees AS e
RIGHT OUTER
JOIN departments AS d ON e.department_id = d.department_id;
 
 
-- Full (Outer) join - Returns the results of an inner join along with all unmatched rows
SELECT *
FROM employees AS e
LEFT OUTER
JOIN departments AS d ON e.department_id=d.department_id UNION
SELECT *
FROM employees AS e
RIGHT OUTER
JOIN departments AS d ON e.department_id=d.department_id;


-- 1.Problem
SELECT e.first_name,e.last_name,t.name AS 'town',a.address_text
FROM employees AS e
INNER JOIN addresses AS a ON e.address_id = a.address_id
INNER JOIN towns AS t ON a.town_id = t.town_id
ORDER BY e.first_name,e.last_name
LIMIT 5;

-- 2.Problem
SELECT e.employee_id, e.first_name,e.last_name,d.name AS 'department_name'
FROM employees AS e
INNER JOIN departments AS d ON e.department_id = d.department_id AND d.name = 'Sales'
ORDER BY e.employee_id DESC;

-- 3.Problem
SELECT e.first_name,e.last_name,e.hire_date,d.name
FROM employees AS e
INNER JOIN departments AS d
ON e.department_id = d.department_id AND
DATE(e.hire_date) > '1999/1/1' AND 
d.name IN ('Sales','Finance')
ORDER BY e.hire_date;


-- 4.Problem
use geography;

SELECT COUNT(*) as 'country_count'
FROM countries AS c
LEFT OUTER JOIN mountains_countries AS mc
ON c.country_code = mc.country_code
WHERE mc.mountain_id IS NULL;


-- 5.Problem
SELECT * FROM employees AS e
 WHERE e.department_id IN 
  (
   SELECT d.department_id    FROM departments AS d
    WHERE d.name = 'Finance'
  );


-- 6.Problem
SELECT MIN(a.min_salary) AS 'min_average_salary'
	FROM 
   	(SELECT AVG(e.salary) as 'min_salary'
		FROM employees AS e 
		GROUP BY e.department_id) 
			AS a;
