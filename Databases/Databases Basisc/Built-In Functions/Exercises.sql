USE `soft_uni`;

-- 2.First name starting with 'Sa'
SELECT e.first_name, e.last_name
FROM `employees` AS `e`
WHERE e.first_name LIKE 'sa%';

-- 3.Find names of all employees by last name( contains 'ei')
SELECT e.first_name, e.last_name
FROM `employees` AS `e`
WHERE e.last_name LIKE '%ei%';


-- 4.Find first names of all employees with ID equals to 3 or 10 and whose hire year is
-- between 1995 and 2005..

SELECT e.first_name
FROM `employees` AS `e`
WHERE e.department_id IN (3,10) AND
YEAR (e.hire_date) BETWEEN 1995 AND 2005;

-- Second solution
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3, 10) AND YEAR(`hire_date`) BETWEEN 1995 AND 2005;

-- 5. Find all employees except engineers
SELECT `first_name`,`last_name`
FROM `employees` AS `e`
WHERE e.job_title NOT LIKE '%engineer' and e.job_title NOT LIKE'engineer%';

SELECT `name`
	FROM `towns`
		WHERE CHAR_LENGTH(`name`) IN (5,6)
			ORDER BY `name`;
			
-- 6. Find towns starting with ...			
SELECT `town_id`, `name`
FROM `towns`
WHERE `name` LIKE 'M%' OR `name` LIKE 'K%' OR `name` LIKE 'B%' OR `name` LIKE 'E%'
ORDER BY `name`;

-- 7. Find towns not starting with .

SELECT `town_id`, `name`
FROM `towns`
WHERE `name` NOT LIKE 'R%' AND `name` NOT LIKE 'B%' AND `name` NOT LIKE 'D%'
ORDER BY `name`;

-- 8. Create view employees hired after 2000 year
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`,`last_name` 
FROM `employees` WHERE YEAR(`hire_date`) > 2000; 

-- 9. Length of Last Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;

-- 10. Countries holding tripple `A`
SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;


-- 11. Mix of Peak and River Names

SELECT `peak_name`,`river_name`, LOWER(CONCAT(`peak_name`,SUBSTRING(`river_name`,2))) as `mix`
FROM `peaks`, `rivers`
WHERE RIGHT(`peak_name`,1) = LEFT(`river_name`,1)
ORDER BY `mix`;

-- 12. Games from 2011 and 2012 year
SELECT `name`,DATE_FORMAT(`start`,'%Y-%m-%d') 
FROM `games`
WHERE YEAR(`start`) IN (2011,2012)
LIMIT 50;

-- 13. User email providers  ( function LOCATE('symbol',STRING) )
SELECT `user_name`, SUBSTRING(`email`,LOCATE('@',`email`)+1) AS `Email Provider`
FROM `users`
ORDER BY `Email Provider`, `user_name`;

-- 14. Get users with IPAddress like pattern
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

