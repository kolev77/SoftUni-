SELECT * FROM departments;
SELECT * FROM `employees`;

SELECT `name`
FROM `departments`;

SELECT e.first_name, e.middle_name,e.last_name
FROM `employees` AS e;

SELECT CONCAT(`first_name`,'.', `last_name`, '@softuni.bg')AS 'full_email_address'
FROM `employees`;

SELECT DISTINCT `salary`
from `employees`;

SELECT * FROM `employees` WHERE `job_title`= 'Sales Representative';

SELECT e.first_name, e.last_name, e.job_title as JobTitle
FROM `employees` AS e WHERE `salary`  BETWEEN 20000 AND 30000;

SELECT CONCAT(`first_name`,' ',`middle_name`,' ',`last_name`) AS 'full_name'
FROM `employees` WHERE `salary` IN (25000, 14000, 12500,23600);

SELECT `first_name`, `last_name` 
from `employees` WHERE `manager_id` IS NULL;

SELECT `first_name`, `last_name`, `salary`
FROM `employees` WHERE `salary` > 50000
ORDER BY `salary` DESC;


SELECT `first_name`, `last_name`
FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

SELECT `first_name`, `last_name`
FROM `employees` 
WHERE `departmant_id`  NOT 4;


-- First option
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` != 4;

-- Second option
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` NOT IN (4);

-- Third option
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `department_id` NOT LIKE 4;

SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name` ASC, `last_name` DESC, `middle_name` ASC;