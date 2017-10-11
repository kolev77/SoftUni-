use soft_uni;

SELECT * FROM departments;

SELECT d.name FROM departments as d;

SELECT e.first_name,e.last_name,e.salary FROM employees as e;

SELECT CONCAT_WS(' ',e.first_name,e.middle_name,e.last_name) AS 'Full Name'   FROM employees as e;

SELECT CONCAT(e.first_name,'.',e.last_name,'@softuni.bg') as 'full_email_address'  FROM employees as e;


SELECT DISTINCT e.salary FROM employees AS e;

SELECT * FROM employees as e where e.job_title = 'Sales Representative';

SELECT e.first_name,e.last_name,e.salary,e.job_title FROM employees as e WHERE e.salary BETWEEN 20000 AND 30000;

SELECT CONCAT_WS(' ',e.first_name,e.middle_name,e.last_name) AS 'Full Name'   FROM employees as e
WHERE e.salary IN (25000,14000,12500,23600);

SELECT e.first_name,e.last_name FROM employees as e where e.manager_id IS NULL;

SELECT e.first_name,e.last_name,e.salary FROM employees as e where e.salary > 50000 ORDER BY e.salary DESC;


SELECT e.first_name,e.last_name,e.salary FROM employees AS e order by e.salary DESC limit 5;

SELECT e.first_name, e.last_name,e.department_id FROM employees as e WHERE e.department_id != 4 ORDER BY e.department_id;


SELECT * FROM employees as e order by e.salary DESC, e.first_name, e.last_name DESC, e.middle_name;


CREATE VIEW `v_employees_salaries` AS SELECT
e.first_name,e.last_name,e.salary FROM employees AS e;

SELECT * FROM v_employees_salaries;


CREATE VIEW `v_employees_job_titles` AS 
SELECT CONCAT_WS(' ',e.first_name,IFNULL(e.middle_name, ''),e.last_name) AS 'full_name',
e.job_title FROM employees as e;

DROP VIEW v_employees_job_titles;
SELECT * FROM v_employees_job_titles;

SELECT DISTINCT e.job_title FROM employees AS e ORDER BY e.job_title;

SELECT * FROM projects AS p ORDER BY p.start_date ASC limit 10;

SELECT  e.first_name,e.last_name, e.hire_date FROM employees as e order by e.hire_date desc limit 7;

UPDATE employees AS e
SET e.salary = e.salary * 1.12
WHERE e.department_id IN (1, 2, 4, 11);

SELECT e.salary FROM employees as e;


-- GEography db

use geography;

SELECT p.peak_name FROM peaks AS p order by p.peak_name;

SELECT c.country_name,c.population FROM countries AS c where c.continent_code = 'EU' order by c.population DESC, c.country_name limit 30;

SELECT c.country_name, c.country_code,
CASE 
	WHEN c.currency_code = 'EUR' THEN 'Euro'
	ELSE 'Not Euro'
	END AS 'currency'
FROM countries as c order by c.country_name;


-- use diablo db

use diablo;

SELECT c.name FROM characters as c ORDER BY c.name;