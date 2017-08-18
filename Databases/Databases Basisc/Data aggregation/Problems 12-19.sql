-- 13.Employees Minimum Salaries
SELECT e.department_id, MIN(e.salary) AS `minimum_salary`
FROM `employees` AS `e`
WHERE e.department_id IN (2,5,7)
GROUP BY e.department_id
ORDER BY e.department_id ASC;


-- 14. Employees Average Salaries


CREATE TABLE `employee`
SELECT *
FROM `employees` AS e
WHERE e.`salary` > 30000;
DELETE FROM `employee`
WHERE `manager_id` = 42;
UPDATE `employee`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;
SELECT `department_id`, AVG(`salary`) AS 'avg_salary'
FROM `employee`
GROUP BY `department_id`
ORDER BY `department_id`;


-- 15. Employees Maximum Salaries

SELECT e.department_id, MAX(e.salary) AS `max_salary`
FROM `employees` AS e
GROUP BY e.department_id
HAVING max_salary NOT BETWEEN 30000 AND 70000
ORDER BY e.department_id;


-- 16. Employees Count Salaries ( without manager )

SELECT COUNT(*) AS `count`
FROM `employees` AS e
WHERE e.manager_id IS NULL;

-- 18. Salary Challenge

SELECT e.`first_name`, e.`last_name`, e.`department_id`
FROM `employees` AS e,
(SELECT e.`department_id`, AVG(e.`salary`) AS 'avg_salary' -- here we made table with columns : department_id and avg_salary
FROM `employees` AS e							
	GROUP BY e.`department_id`) AS `avg_salary_table`
		WHERE e.`department_id` = `avg_salary_table`.`department_id` -- here we compare IDs and Salaries
			AND e.`salary` > `avg_salary_table`.`avg_salary`
				ORDER BY e.`department_id` -- order them 
					LIMIT 10;


-- 19. Departments Total Salaries
SELECT e.department_id, SUM(e.salary) AS `total_salary`
FROM `employees` AS `e`
GROUP BY e.department_id;