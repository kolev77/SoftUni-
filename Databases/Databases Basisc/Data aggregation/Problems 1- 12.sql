-- 1.Records Count
SELECT COUNT(*) FROM `wizzard_deposits`;

-- 2.Longest Maginc Wand

SELECT MAX(w.magic_wand_size) FROM `wizzard_deposits` as `w`;

-- 3.Longest Magic Wand per Deposit Groups

SELECT w.deposit_group,MAX(w.magic_wand_size) AS 'longest_magic_wand'
FROM `wizzard_deposits` as `w`
GROUP BY w.deposit_group
ORDER BY `longest_magic_wand`,w.deposit_group;

-- 4. Smallest Deposit Group Per Magic Wand Size

SELECT aws.`deposit_group` FROM
(SELECT wd.deposit_group,
			AVG(wd.magic_wand_size) AS `average_wand_size`
FROM `wizzard_deposits` AS `wd`
GROUP BY wd.deposit_group
ORDER BY `average_wand_size`) AS `aws`
LIMIT 1;


-- 5. Deposits Sum

SELECT  wd.deposit_group, SUM(wd.deposit_amount) AS `total_sum`
FROM `wizzard_deposits` AS `wd`
GROUP BY wd.deposit_group
ORDER BY `total_sum`;


-- 6. Deposits Sum For Ollivander family

SELECT  wd.deposit_group, SUM(wd.deposit_amount) AS `total_sum`
FROM `wizzard_deposits` AS `wd`
WHERE wd.magic_wand_creator LIKE 'Ollivander%'
GROUP BY wd.deposit_group
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;


-- 7.Deposit charge
SELECT wd.deposit_group, wd.magic_wand_creator,MIN(wd.deposit_charge) AS `min_deposit`
FROM `wizzard_deposits` AS `wd`
GROUP BY wd.deposit_group, wd.magic_wand_creator
ORDER BY wd.magic_wand_creator, wd.deposit_group;

		-- info about deposits
select wd.id, wd.first_name, wd.magic_wand_creator, wd.deposit_charge from `wizzard_deposits` as `wd` WHERE wd.deposit_group LIKE 'Blue%' ;

select * from `wizzard_deposits`;

-- 9. Age Groups

SELECT a.age_group, COUNT(*) AS `wizard_count` FROM
(SELECT
	CASE
		WHEN wd.age BETWEEN 0 AND 10 THEN '[0-10]'
		WHEN wd.age BETWEEN 11 AND 20 THEN '[11-20]'			
		WHEN wd.age BETWEEN 21 AND 30 THEN '[21-30]'
		WHEN wd.age BETWEEN 31 AND 40 THEN '[31-40]'
		WHEN wd.age BETWEEN 41 AND 50 THEN '[41-50]'
		WHEN wd.age BETWEEN 51 AND 60 THEN '[51-60]'
		ELSE '[61+]'
	END AS `age_group`
	
		FROM `wizzard_deposits` AS `wd`) AS `a`
		GROUP BY a.age_group;
		
		
-- 10. First letter
SELECT DISTINCT SUBSTRING(wd.first_name,1,1) AS `first_letter` FROM `wizzard_deposits` AS `wd` WHERE
wd.deposit_group LIKE 'Troll%'
ORDER BY `first_letter`;

-- 11. Average Interest
SELECT wd.deposit_group, wd.is_deposit_expired, AVG(wd.deposit_interest) AS `average_interest`
FROM `wizzard_deposits` AS `wd`
WHERE wd.deposit_start_date > '1985/01/01'
GROUP BY wd.deposit_group, wd.is_deposit_expired
ORDER BY wd.deposit_group DESC, wd.is_deposit_expired ASC;


-- 12.Rich Wizard, Poor Wizard
    -- first query 
SELECT wd1.first_name AS `host_wizard`,
		  wd1.deposit_amount AS `host_wizard_deposit`,
		  wd2.first_name AS `guest_wizard`,
		  wd2.deposit_amount AS `guest_wizard_deposit`,
		  wd1.deposit_amount - wd2.deposit_amount AS `difference`
FROM `wizzard_deposits` AS `wd1`, `wizzard_deposits` AS `wd2`
WHERE wd1.id + 1 = wd2.id;

	
SELECT SUM(game_table.difference) AS `difference`
FROM
(SELECT wd1.first_name AS `host_wizard`,
		  wd1.deposit_amount AS `host_wizard_deposit`,
		  wd2.first_name AS `guest_wizard`,
		  wd2.deposit_amount AS `guest_wizard_deposit`,
		  wd1.deposit_amount - wd2.deposit_amount AS `difference`
FROM `wizzard_deposits` AS `wd1`, `wizzard_deposits` AS `wd2`
WHERE wd1.id + 1 = wd2.id) AS `game_table`;


