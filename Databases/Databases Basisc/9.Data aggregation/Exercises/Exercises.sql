USE gringotts;

-- 1.Problem
SELECT COUNT(*)
FROM wizzard_deposits AS w;


-- 2.Problem
SELECT MAX(w.magic_wand_size) AS 'longest_magic_wand'
FROM wizzard_deposits AS w;

-- 3.Problem
SELECT w.deposit_group, MAX(w.magic_wand_size) AS 'longest_magic_wand'
FROM wizzard_deposits AS w
GROUP BY w.deposit_group
ORDER BY longest_magic_wand, w.deposit_group;

-- 4.Problem
SELECT w.deposit_group
FROM wizzard_deposits AS w
GROUP BY w.deposit_group
ORDER BY AVG(w.magic_wand_size)
LIMIT 1;


-- 5.Problem
SELECT w.deposit_group, SUM(w.deposit_amount) AS 'total_sum'
FROM wizzard_deposits AS w
GROUP BY w.deposit_group
ORDER BY total_sum;

-- 6.Problem
SELECT w.deposit_group, SUM(w.deposit_amount) AS 'total_sum'
FROM wizzard_deposits AS w
WHERE w.magic_wand_creator = 'Ollivander family'
GROUP BY w.deposit_group
ORDER BY w.deposit_group;


-- 7.Problem
SELECT w.deposit_group,w.magic_wand_creator, MIN(w.deposit_charge) AS 'min_deposit'
FROM wizzard_deposits AS w
GROUP BY w.deposit_group,w.magic_wand_creator
ORDER BY w.magic_wand_creator, w.deposit_group;

-- 8.Problem
SELECT a.age_group, COUNT(*) AS `wizard_count`
FROM
(
SELECT CASE WHEN w.age BETWEEN 0 AND 10 THEN '[0-10]' WHEN w.age BETWEEN 11 AND 20 THEN '[11-20]' WHEN w.age BETWEEN 21 AND 30 THEN '[21-30]' WHEN w.age BETWEEN 31 AND 40 THEN '[31-40]' WHEN w.age BETWEEN 41 AND 50 THEN '[41-50]' WHEN w.age BETWEEN 51 AND 60 THEN '[51-60]' ELSE '[61+]' END AS `age_group`
FROM wizzard_deposits AS w) AS `a`
GROUP BY a.age_group;
		
-- 9.Problem
SELECT SUBSTRING(w.first_name,1,1) AS 'first_letter'
FROM wizzard_deposits AS w
WHERE w.deposit_group = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY first_letter; 

-- 11.Problem
SELECT w.deposit_group, w.is_deposit_expired, AVG(w.deposit_interest) AS 'average_interest'
FROM wizzard_deposits AS w
WHERE w.deposit_start_date > '1985-01-01'
GROUP BY w.deposit_group,w.is_deposit_expired
ORDER BY w.deposit_group DESC,w.is_deposit_expired ASC;

-- 12.Problem
SELECT sum(a.host_wizzard_deposit - a.guest_wizzard_deposit) as 'sum_difference' FROM
(SELECT w1.first_name AS 'host_wizzard', w1.deposit_amount AS 'host_wizzard_deposit',
 w2.first_name AS 'guest_wizzard', w2.deposit_amount AS 'guest_wizzard_deposit'
FROM wizzard_deposits AS w1, wizzard_deposits AS w2
WHERE w1.id +1 = w2.id) AS `a`;


SELECT SUM(host_wizzard_deposit - guest_wizzard_deposit) as 'sum_difference'  FROM
rw_pw ;


use soft_uni;
-- 13.Problem

SELECT e.department_id, MIN(e.salary) as 'minimum_salary'
FROM employees AS e
WHERE e.department_id IN (2,5,7) AND e.hire_date > '2000-01-01'
GROUP BY e.department_id
ORDER BY e.department_id;


-- 14.Problem
CREATE TABLE `new_table`
SELECT * FROM employees as e
WHERE e.salary > 30000;
DELETE FROM new_table
WHERE manager_id = 42;
UPDATE new_table as n
SET n.salary = n.salary + 5000
WHERE n.department_id = 1;
SELECT n.department_id, AVG(n.salary) AS 'avg_salary'
FROM new_table AS n
GROUP BY n.department_id
ORDER BY n.department_id;


-- 15.Problem
SELECT e.department_id, MAX(e.salary) AS 'max_salary'
FROM employees AS e
GROUP BY e.department_id
HAVING `max_salary` NOT BETWEEN 30000 AND 70000;

-- 16.Problem
SELECT COUNT(*) AS 'count'
FROM employees AS e
WHERE e.manager_id IS NULL;

-- 17.Problem
SELECT e.department_id,MAX(e.salary) as 'third_highest_salary'
FROM employees AS e,
	(SELECT e.department_id,MAX(e.salary) as 'max'
	FROM employees AS e,
		(SELECT e.department_id, MAX(e.salary) as 'max'
		FROM employees AS e
		GROUP BY e.department_id) as max_1
	WHERE e.department_id = max_1.department_id
		AND e.salary < max_1.`max`
		GROUP BY e.department_id) as max_2
	WHERE e.department_id = max_2.department_id
	AND e.salary < max_2.`max`
	GROUP BY e.department_id;
	
-- 18.Problem

SELECT e.first_name,e.last_name,e.department_id
FROM employees AS e,
	(SELECT e.department_id, AVG(e.salary) AS 'average_salary'
	FROM employees AS e
	GROUP BY e.department_id) AS dps
	WHERE e.department_id = dps.department_id
	AND e.salary > dps.average_salary
	ORDER BY e.department_id LIMIT 10;

-- 19.Problem
SELECT e.department_id,SUM(e.salary) AS 'total_salary'
FROM employees AS e
GROUP BY e.department_id;