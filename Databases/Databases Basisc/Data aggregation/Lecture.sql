SET sql_mode='ONLY_FULL_GROUP_BY';
-- Group by
-- 19.	Departments Total Salaries
SELECT e.department_id, SUM(e.salary) AS `TotalSalary`
FROM `employees` as `e`
GROUP BY e.department_id;


SELECT e.first_name, e.last_name
FROM `employees` AS `e`
GROUP BY e.first_name, e.last_name ;

-- check function group_concat()   !!!

SELECT e.department_id, MIN(e.salary) AS `MinSalary`
FROM `employees` AS `e`
GROUP BY e.department_id;

SELECT e.first_name,e.last_name,
 MIN(e.salary) AS `MinSalary`
FROM `employees` AS `e`
GROUP BY e.first_name, e.last_name
ORDER BY `MinSalary`;

-- SUM 
SELECT e.department_id, SUM(e.salary) AS `Total Salary`
FROM `employees` AS `e` GROUP BY e.department_id;

SELECT e.department_id, SUM(e.salary)+ e.department_id AS `Total Salary + ID`
FROM `employees` AS `e` GROUP BY e.department_id;

-- COUNT - counts the values (not nulls) in one or more columns based 
-- on grouping criteria.
SELECT e.department_id ,COUNT(e.salary) AS `SalaryCount`
FROM `employees` AS `e` GROUP BY e.department_id ORDER BY `SalaryCount`;

SELECT COUNT(*) FROM `employees` AS `e`;

-- MAX () 

SELECT e.department_id, MAX(e.salary) AS `MAX Salary`
FROM `employees` AS `e` GROUP BY e.department_id ORDER BY `MAX Salary`;




-- Nested query
--   Sum best salaries
SELECT
	SUM(p.max_salaries)
FROM
	(SELECT 
		e.department_id, MAX(e.salary) AS `max_salaries`
		FROM
			`employees` as `e`
			GROUP BY e.department_id) AS `p`;
			

-- AVERAGE -- >  AVG() (without nulls)

SELECT e.department_id, AVG(e.salary)
FROM `employees` AS `e`
GROUP BY e.department_id;


SELECT 
	AVG(e.salary)
FROM `employees` AS `e`;

SELECT SUM(e.salary) / COUNT(e.salary)  FROM `employees` AS `e`;

-- EXAMPLES
		-- HAVING  equal to WHERE
SELECT e.`department_id`, 
  AVG(e.`salary`) AS 'AvgSalary'
FROM `employees` AS e -- HERE WE CAN PUT "WHERE"
GROUP BY e.`department_id`
HAVING `AvgSalary` > 15000;


