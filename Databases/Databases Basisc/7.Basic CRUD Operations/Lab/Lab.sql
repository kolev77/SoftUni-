USE `soft_uni`;
-- ------
SELECT DISTINCT CONCAT_WS(' ',e.first_name,e.middle_name,e.last_name) AS 'Full Name',
	 e.job_title AS 'Job Title',
	 e.salary AS 'Salary'
FROM `employees` AS `e`;
 	
-- -------------
SELECT DISTINCT `department_id`
FROM `employees`;

-- -------
SELECT e.first_name,e.last_name,e.manager_id
FROM employees AS `e`
WHERE NOT(e.manager_id = 16 OR e.manager_id = 4 OR e.manager_id = 6)
ORDER BY e.first_name;
	
-- ---------
SELECT DISTINCT CONCAT(e.department_id,' - ',e.manager_id) AS `a`
FROM employees AS `e`;

-- Create view
CREATE VIEW `v_employees_w_salaries` AS
SELECT CONCAT(e.first_name,' ',e.last_name) AS 'Full name',e.salary
FROM employees AS `e`
ORDER BY e.salary;
DROP VIEW v_employees_w_salaries;
SELECT *
FROM v_employees_w_salaries;

-- USE GEOGRAPHY DATABASE
USE geography;
CREATE VIEW `v_highest_peak` AS
SELECT *
FROM peaks AS `p`
ORDER BY p.elevation DESC
LIMIT 1;
SELECT *
FROM `v_highest_peak`;
INSERT INTO towns VALUES (55,'VARNICHKA'); USE `soft_uni`;

-- create table from another one
CREATE TABLE `customer_contacts` AS
SELECT e.employee_id,e.first_name,e.salary
FROM employees AS e;

CREATE TABLE `customer_distinct` AS
SELECT DISTINCT e.manager_id
FROM employees AS e;

ALTER TABLE customer_distinct ADD COLUMN department_id INT;

INSERT INTO customer_distinct(department_id)
SELECT DISTINCT department_id FROM employees;

-- Update these projects with End_date = null to current date

UPDATE projects AS p 
	SET p.end_date = '2017-03-25'
	where p.end_date IS NULL;
	