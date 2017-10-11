USE soft_uni;

-- Get total salaries by department
SELECT e.`department_id`, SUM(e.`salary`) AS 'Total Salary'
FROM `employees` AS e
GROUP BY e.`department_id`
ORDER BY e.`department_id`;

-- GET number of employees by department
SELECT e.job_title,COUNT(e.employee_id) AS 'Number of employees'
FROM employees as e
GROUP by e.job_title
ORDER BY COUNT(e.employee_id) DESC;

SELECT DISTINCT e.first_name
FROM employees AS e;

SELECT  e.first_name
FROM employees AS e
GROUP BY e.first_name;

-- Get first names of employees by job title
SELECT e.job_title, GROUP_CONCAT(e.first_name,' ') AS 'employees'
FROM employees AS e
GROUP BY e.job_title;

-- 
SELECT e.department_id, MIN(e.salary)  AS 'Min Salary'
FROM employees AS e
GROUP BY e.department_id
ORDER BY MIN(e.salary);


SELECT e.department_id, COUNT(e.salary) AS 'Total Salary'
FROM employees AS e
GROUP BY e.department_id;

-- Get max salary of each department
SELECT e.department_id, MAX(e.salary) AS 'MaxSalary' 
FROM employees AS e GROUP BY e.department_id;

-- Get sum of all max salaries
SELECT
	SUM(s.`MaxSalary`) AS 'Sum'FROM 
     (SELECT e.department_id, 
		MAX(e.salary) AS 'MaxSalary' 
		FROM employees AS e
	   GROUP BY e.department_id) AS s;
	   
	   
SELECT e.department_id,AVG(e.salary) AS 'Average'
FROM employees AS e
GROUP BY e.department_id;

SELECT AVG(e.salary)
FROM employees as e;


SELECT e.department_id, AVG(e.salary) AS 'AvgSalary'
FROM employees as e
GROUP BY e.department_id
HAVING AvgSalary > 20000; 


