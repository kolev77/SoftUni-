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

-- MULTIPLE JOIN
SELECT * FROM employees_projects;

SELECT p.project_id ,e.first_name, e.last_name, p.name FROM employees AS e
INNER JOIN employees_projects AS ep
ON e.employee_id = ep.employee_id
INNER JOIN projects AS p
ON ep.project_id = p.project_id
ORDER BY p.project_id;

-- FIND Employee without project
SELECT e.employee_id, e.first_name, p.name FROM projects AS p
LEFT OUTER JOIN employees_projects AS ep
ON ep.project_id = p.project_id
LEFT OUTER JOIN employees AS e
ON e.employee_id = ep.employee_id
WHERE e.employee_id IS NULL;


-- 2.Problem: Addresses in SoftUni

SELECT e.first_name, e.last_name,t.name AS 'town' ,a.address_text FROM employees AS e
INNER JOIN addresses AS a
ON e.address_id = a.address_id
INNER JOIN towns AS t 
on a.town_id = t.town_id
ORDER BY e.first_name,e.last_name
LIMIT 5;

SELECT e.employee_id, e.first_name, e.last_name, d.name AS department_name FROM employees AS e
INNER JOIN departments AS d
ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY employee_id DESC;



SELECT e.first_name, e.last_name,e.hire_date, d.name FROM employees AS e
	INNER JOIN departments AS d
		ON e.department_id = d.department_id
		AND DATE(e.hire_date) > '1999/1/1'
        AND d.name IN ('Sales','Finance')
        ORDER BY e.hire_date;
        
        
-- SELECT COUNTRIES without any mountains

SELECT * FROM mountains_countries;

SELECT COUNT(*) FROM countries as c
LEFT OUTER JOIN mountains_countries AS mc
ON mc.country_code= c.country_code
WHERE mc.country_code IS NULL;

-- 

SELECT  e.employee_id, e.salary FROM employees AS e
WHERE e.department_id IN (SELECT 
				d.department_id FROM departments AS d
					WHERE d.name = 'Finance');


-- Select the average salaries of each department and show only the smallest one
SELECT MIN(a.avg) AS 'min_average_salary' FROM
(SELECT AVG(e.salary) AS 'avg' FROM employees AS e
GROUP BY e.department_id) AS a; 


-- HOW TO CREATE INDEX

CREATE INDEX ix_employees_salary
ON employees(salaryemployees);

