-- 1.Problem
SELECT e.employee_id,e.job_title,e.address_id,a.address_text
FROM employees AS e
INNER JOIN addresses AS a ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;

-- 2.Problem
SELECT e.first_name,e.last_name,t.name AS 'town',a.address_text
FROM employees AS e
INNER JOIN addresses AS a ON e.address_id = a.address_id
INNER JOIN towns AS t ON a.town_id = t.town_id
ORDER BY e.first_name,e.last_name
LIMIT 5;

-- 3.Problem
SELECT e.employee_id,e.first_name,e.last_name,d.name AS 'department_name'
FROM employees AS e
INNER JOIN departments AS d ON e.department_id = d.department_id AND d.name = 'Sales'
ORDER BY e.employee_id DESC;

-- 4.Problem
SELECT e.employee_id, e.first_name,e.salary,d.name AS 'department_name'
FROM employees AS e
INNER JOIN departments AS d ON e.department_id = d.department_id AND e.salary > 15000
ORDER BY e.department_id DESC
LIMIT 5;


-- 5.Problem
SELECT e.employee_id,e.first_name
FROM employees AS e
LEFT OUTER
JOIN employees_projects AS p ON e.employee_id = p.employee_id
WHERE p.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

-- 6.Problem
SELECT e.first_name,e.last_name,e.hire_date,d.name AS 'dept_name'
FROM employees AS e
INNER JOIN departments AS d ON e.department_id = d.department_id AND DATE(e.hire_date) >'1999/1/1' AND d.name IN ('Finance','Sales')
ORDER BY e.hire_date;


-- 7.Problem
SELECT e.employee_id,e.first_name,p.name AS 'project_name'
FROM employees AS e
INNER JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
INNER JOIN projects AS p ON ep.project_id = p.project_id AND DATE(p.start_date) > '2002/08/13' AND p.end_date IS NULL
ORDER BY e.first_name,p.name
LIMIT 5;

-- 8.Problem
SELECT e.employee_id,e.first_name, CASE WHEN YEAR(p.start_date) >= 2005 THEN NULL ELSE p.name END AS 'project_name'
FROM employees AS e
INNER JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
INNER JOIN projects AS p ON ep.project_id = p.project_id AND e.employee_id = 24
ORDER BY p.name;

-- 9.Problem
SELECT e.employee_id, e.first_name,e.manager_id,e1.first_name AS 'manager_name'
FROM employees AS e
INNER JOIN employees AS e1 ON e.manager_id = e1.employee_id AND e.manager_id IN (3,7)
ORDER BY e.first_name;

-- 10.Problem
SELECT e.employee_id, CONCAT(e.first_name,' ',e.last_name) AS 'employee_name', CONCAT(m.first_name,' ',m.last_name) AS 'manager_name',d.name AS 'department_name'
FROM employees AS e
INNER JOIN employees AS m ON e.manager_id = m.employee_id AND e.manager_id IS NOT NULL
INNER JOIN departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

-- 11.Problem
SELECT MIN(b.salary) AS 'min_average_salary'
FROM (
SELECT AVG(e.salary) AS 'salary',e.department_id
FROM employees AS e
GROUP BY e.department_id) AS b;

-- 12.Problem
USE geography;
SELECT c.country_code,m.mountain_range,p.peak_name,p.elevation
FROM countries AS c
INNER JOIN mountains_countries AS mc ON c.country_code = mc.country_code
INNER JOIN mountains AS m ON m.id = mc.mountain_id
INNER JOIN peaks AS p ON p.mountain_id = m.id AND p.elevation > 2835 AND c.country_code = 'BG'
ORDER BY p.elevation DESC; 

-- 13.Problem
SELECT c.country_code, COUNT(mc.mountain_id) AS 'mountain_range'
FROM countries AS c
INNER JOIN mountains_countries AS mc ON c.country_code = mc.country_code
WHERE c.country_name IN('United States', 'Russia', 'Bulgaria')
GROUP BY c.country_code
ORDER BY `mountain_range` DESC;


-- 14.Problem
SELECT c.country_name,r.river_name
FROM countries AS c
INNER JOIN continents AS cont ON c.continent_code = cont.continent_code AND cont.continent_name = 'Africa'
LEFT OUTER
JOIN countries_rivers AS cr ON c.country_code = cr.country_code
LEFT OUTER
JOIN rivers AS r ON cr.river_id = r.id
ORDER BY c.country_name
LIMIT 5;

-- 15.Problem
-- WITH SUBQUERIES
SELECT cu.continent_code,cu.currency_code,cu.currency_usage
FROM
		(SELECT b.continent_code, b.currency_code, MAX(b.max_usage) AS 'currency_usage'
			  FROM
					(SELECT cont.continent_code,c.currency_code, COUNT(*) AS 'max_usage'
					FROM continents AS cont
					INNER JOIN countries AS c ON cont.continent_code = c.continent_code
					GROUP BY cont.continent_code,c.currency_code) AS b
			 GROUP BY b.currency_code,b.continent_code
			 HAVING `currency_usage` >1
			 ORDER BY b.continent_code,b.currency_code) AS cu,
			 
							(SELECT cu_usages.continent_code, max(cu_usages.currency_usage) AS 'max_usage'
							FROM
								(SELECT b.continent_code, b.currency_code, MAX(b.max_usage) AS 'currency_usage'
											  FROM
													(SELECT cont.continent_code,c.currency_code, COUNT(*) AS 'max_usage'
													FROM continents AS cont
													INNER JOIN countries AS c ON cont.continent_code = c.continent_code
													GROUP BY cont.continent_code,c.currency_code) AS b
											 GROUP BY b.currency_code,b.continent_code
											 HAVING `currency_usage` >1
											 ORDER BY b.continent_code,b.currency_code) AS cu_usages
							GROUP BY cu_usages.continent_code) AS max_curr			
WHERE cu.continent_code = max_curr.continent_code
AND cu.currency_usage = max_curr.max_usage;

-- WITH VIEWS

CREATE VIEW `continent_currency_usg`
AS
SELECT b.continent_code, b.currency_code, MAX(b.max_usage) AS 'currency_usage'
			  FROM
					(SELECT cont.continent_code,c.currency_code, COUNT(*) AS 'max_usage'
					FROM continents AS cont
					INNER JOIN countries AS c ON cont.continent_code = c.continent_code
					GROUP BY cont.continent_code,c.currency_code) AS b
			 GROUP BY b.currency_code,b.continent_code
			 HAVING `currency_usage` >1
			 ORDER BY b.continent_code,b.currency_code;
			 
SELECT * FROM continent_currency_usg;

SELECT * FROM max_usage;

SELECT c.continent_code,c.currency_code,c.currency_usage
FROM continent_currency_usg AS c, max_usage AS m
WHERE c.continent_code = m.continent_code
AND c.currency_usage = m.max_usage;


-- 16.Problem

SELECT COUNT(*) as 'country_count'
FROM countries AS c
LEFT OUTER JOIN mountains_countries AS mc
ON c.country_code = mc.country_code
WHERE mc.mountain_id IS NULL;


-- 17.Problem

-- First part
SELECT c.country_name,MAX(p.elevation) AS 'highest_peak_elevation'
FROM countries AS c
INNER JOIN mountains_countries AS mc
ON c.country_code = mc.country_code
INNER JOIN peaks AS p
ON mc.mountain_id = p.mountain_id
GROUP BY c.country_name;

-- Second part
SELECT c.country_name,MAX(r.length) as 'longest_river_length'
FROM countries AS c
INNER JOIN countries_rivers AS cr
ON c.country_code = cr.country_code
INNER JOIN rivers AS r
ON cr.river_id = r.id
GROUP BY c.country_name;


-- Full problem
SELECT a.country_name,a.highest_peak_elevation,b.longest_river_length
	FROM  
		(SELECT c.country_name,MAX(p.elevation) AS 'highest_peak_elevation'
		FROM countries AS c
		INNER JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
		INNER JOIN peaks AS p
		ON mc.mountain_id = p.mountain_id
		GROUP BY c.country_name) AS a,
		
		(SELECT c.country_name,MAX(r.length) as 'longest_river_length'
		FROM countries AS c
		INNER JOIN countries_rivers AS cr
		ON c.country_code = cr.country_code
		INNER JOIN rivers AS r
		ON cr.river_id = r.id
		GROUP BY c.country_name) AS b
		
		WHERE a.country_name = b.country_name
		ORDER BY a.highest_peak_elevation DESC,
		b.longest_river_length DESC,
		a.country_name
		LIMIT 5;
		