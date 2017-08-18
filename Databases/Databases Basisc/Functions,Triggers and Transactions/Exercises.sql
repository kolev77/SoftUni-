-- 1. Employees with Salary above 35000
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT e.first_name, e.last_name
    FROM employees AS e
    WHERE e.salary > 35000
    ORDER BY e.first_name, e.last_name;
END $$

DELIMITER ;

-- 2
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary_level DECIMAL(19,4))
BEGIN
    SELECT e.first_name, e.last_name
    FROM employees AS e
    WHERE e.salary >= salary_level
    ORDER BY e.first_name, e.last_name;
END$$
DELIMITER ;

-- 3. Town Names Starting with
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(input VARCHAR(50))
BEGIN
    SELECT t.name
    FROM towns AS t
    WHERE SUBSTRING(t.name, 1, CHAR_LENGTH(input)) = input
    ORDER BY t.name;
END$$
DELIMITER ;

-- 4. Employees from town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town  (input_town VARCHAR(20))
BEGIN

SELECT e.first_name, e.last_name 
      FROM employees AS e, towns AS t, addresses AS a
WHERE input_town = t.name AND t.town_id = a.town_id AND a.address_id = e.address_id
ORDER BY e.first_name, e.last_name;

END$$
DELIMITER ;

-- 5. Salary level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)

BEGIN
   DECLARE salary_level VARCHAR(10);
   
   IF (salary < 30000) THEN SET salary_level = 'Low';
   ELSEIF(salary >= 30000 AND salary <= 50000) THEN SET salary_level = 'Average';
   ELSEIF(salary > 50000) THEN SET salary_level = 'High';
   END IF;
   
   RETURN salary_level;
   
END $$
DELIMITER ;

-- 6. Employee by salary level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
	SELECT e.first_name, e.last_name FROM employees AS e
    INNER JOIN (SELECT e.employee_id,e.salary, 
	 CASE WHEN e.salary < 30000 THEN 'Low' 
	      WHEN e.salary BETWEEN 30000 AND 50000 THEN 'Average' 
			WHEN e.salary > 50000 THEN 'High' 
			END 
			AS 'salary_level' FROM employees AS e) AS sl
    ON e.employee_id = sl.employee_id
    WHERE salary_level = sl.salary_level
    ORDER BY e.first_name DESC, e.last_name DESC;
END $$

DELIMITER ;

--  7. Define function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised (set_of_chars VARCHAR(30),word VARCHAR(200)) RETURNS BOOL
BEGIN
       DECLARE len INT DEFAULT CHAR_LENGTH(word);
       DECLARE index_ INT DEFAULT 1;
       WHILE index_ <= len
       DO
          IF locate(SUBSTRING(word,index_,1),set_of_chars) < 1 THEN
            RETURN FALSE;
          END IF;
          SET index_ = index_ + 1;
		 END WHILE;
	RETURN TRUE;	        
END$$

DELIMITER ;


-- 8 . DELETE employees of given department and the department itself

DELETE FROM employees_projects
WHERE employees_projects.employee_id IN
(
	SELECT e.employee_id
	FROM employees AS `e`
	WHERE e.department_id = (SELECT d.department_id FROM departments AS `d` WHERE(d.name = 'Production'))
	OR e.department_id = (SELECT d.department_id FROM departments AS `d` WHERE(d.name = 'Production Control'))
);

UPDATE employees AS `e`
SET e.manager_id = NULL
WHERE e.department_id = (SELECT d.department_id FROM departments AS `d` WHERE(d.name = 'Production'))
OR e.department_id = (SELECT d.department_id FROM departments AS `d` WHERE(d.name = 'Production Control'));

ALTER TABLE departments
MODIFY COLUMN manager_id INT NULL;

UPDATE departments AS `d`
SET d.manager_id = NULL
WHERE(d.name = 'Production' or d.name = 'Production Control');

ALTER TABLE employees
DROP FOREIGN KEY fk_employees_employees;

DELETE FROM employees
WHERE employees.department_id = (SELECT d.department_id FROM departments AS `d` WHERE(d.name = 'Production'))
OR employees.department_id = (SELECT d.department_id FROM departments AS `d` WHERE(d.name = 'Production Control'));

DELETE FROM departments
WHERE (name = 'Production' OR name = 'Production Control');


-- 9. Find full name
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT_WS(' ', a.first_name, a.last_name) AS 'full_name'
	FROM account_holders AS a
	ORDER BY a.first_name, a.last_name;
END$$

DELIMITER ;


-- 10. People with balance higher than 
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(total_amount DECIMAL(19,4))
BEGIN
	SELECT total_balance.first_name, total_balance.last_name
	FROM
	(SELECT ah.first_name, ah.last_name, SUM(a.balance) as `sum`
	FROM `account_holders` AS ah
	INNER JOIN `accounts` AS a
	ON ah.id = a.account_holder_id
	GROUP BY ah.first_name, ah.last_name) as total_balance
	WHERE total_balance.`sum` > total_amount
	ORDER BY total_balance.first_name, total_balance.last_name;
END $$

DELIMITER ;


-- 11 . Future value

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19,2), yearly_interest_rate DECIMAL(19,2), number_of_years INT)
  RETURNS DECIMAL(19,2)
  BEGIN
    DECLARE future_value DECIMAL(19, 2);
    SET future_value := (initial_sum * (POW((1 + yearly_interest_rate), number_of_years)));
    RETURN future_value;
  END$$
DELIMITER ;


-- 12 . Calculating Interest

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account (account_id INT, interest_rate DECIMAL(19,4))

BEGIN

  DECLARE future_value DECIMAL(19,4);

  DECLARE balance DECIMAL(19, 4);

  SET balance := (SELECT a.balance FROM accounts AS a WHERE a.id = account_id);

  SET future_value := balance * (POW((1 + interest_rate), 5));

  SELECT a.id AS account_id, ah.first_name, ah.last_name, a.balance, future_value

    FROM accounts AS a

   INNER JOIN account_holders AS ah

      ON a.account_holder_id = ah.id

     AND a.id = account_id;

END$$
DELIMITER ;


-- 13 . Deposit Money

DROP PROCEDURE IF EXISTS usp_deposit_money;
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(IN account_id INT,IN money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    UPDATE accounts SET accounts.balance = accounts.balance + money_amount
    WHERE accounts.id = account_id;    
    
    IF money_amount <= 0
    THEN
	    ROLLBACK;
    ELSE
       COMMIT;
    END IF;

END$$
DELIMITER  ; 

call usp_deposit_money(1,200);
select*from accounts as a where a.id = 1; 


-- 14 . Withdraw Money

DELIMITER $$

CREATE PROCEDURE usp_withdraw_money  (IN account_id INT, IN money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
	UPDATE accounts SET accounts.balance = accounts.balance-money_amount
	WHERE accounts.id = account_id;	

 IF((SELECT a1.balance FROM accounts AS `a1` WHERE account_id = a1.id) < 0)
  THEN ROLLBACK;
 END IF;
 IF(money_amount <= 0 OR account_id > 18 OR account_id < 1) 
 THEN ROLLBACK;
 END IF;
COMMIT;	
END $$ 
DELIMITER ;

-- 15 . Problem 15.	Money Transfer

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4)) 
BEGIN
	START TRANSACTION;
		UPDATE accounts SET balance = balance - amount
			WHERE id = from_account_id;
			UPDATE accounts SET balance = balance + amount
			WHERE id = to_account_id;
			
		IF((SELECT COUNT(*) FROM accounts
		      WHERE id = from_account_id) <> 1)
		   THEN ROLLBACK;
		ELSEIF(amount > (SELECT balance FROM accounts WHERE id = from_account_id))
			THEN ROLLBACK;
		ELSEIF(amount <= 0)
			THEN ROLLBACK;
		ELSEIF((SELECT balance FROM accounts WHERE id = from_account_id) <= 0)
			THEN ROLLBACK;	
		ELSEIF((SELECT COUNT(*) FROM accounts
		      WHERE id = to_account_id) <> 1)
		   THEN ROLLBACK;
		ELSEIF(amount <= 0)
			THEN ROLLBACK;
		ELSEIF(from_account_id = to_account_id)
			THEN ROLLBACK;
		ELSE 
			COMMIT;
		END IF;

END $$
DELIMITER ;


-- 16.Log Accounts Trigger
create table logs 
(
	log_id INT AUTO_INCREMENT PRIMARY KEY, 
	account_id INT, 
	old_sum DECIMAL(19,4), 
	new_sum DECIMAL(19,4)
); 

DELIMITER $$
CREATE TRIGGER after_accounts_update
AFTER UPDATE 
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id, old_sum, new_sum)
	VALUES (OLD.id, OLD.balance, NEW.balance);
END $$
DELIMITER ;



-- 17.	Emails Trigger

CREATE TABLE logs(
	log_id INT AUTO_INCREMENT PRIMARY KEY,
	account_id INT,
	old_sum DECIMAL(19,4),
	new_sum DECIMAL(19, 4)
);
CREATE TABLE notification_emails(
	id INT AUTO_INCREMENT PRIMARY KEY,
	recipient INT,
	subject VARCHAR(50),
	body TEXT
);
DELIMITER $$
CREATE TRIGGER tr_emails
AFTER UPDATE
ON accounts
FOR EACH ROW 
BEGIN
	INSERT INTO logs(account_id, old_sum, new_sum)
	VALUES(old.id, old.balance, new.balance);
	INSERT INTO notification_emails(recipient, subject, body)
	VALUES(
		old.id,
		CONCAT_WS(': ', 'Balance change for account', old.id),
		CONCAT('On ', NOW(), ' your balance was changed from ', old.balance, ' to ', new.balance, '.' ));
END $$



-- 18. Massive Shopping

CREATE PROCEDURE usp_buy_item(IN user_id INT, IN item_name VARCHAR(50))
BEGIN
	DECLARE item_price DECIMAL(19,4);
    SET item_price = (SELECT price FROM items WHERE name = item_name);
    INSERT INTO user_game_items(item_id,user_game_id)
    VALUES ((SELECT id FROM items WHERE name = item_name),user_id);
    UPDATE users_games
    SET cash = cash - item_price
    WHERE id = user_id;
END;

CREATE PROCEDURE usp_buy_items_from_lvl_11_to_12()
BEGIN
	DECLARE stamat_safflower_id INT;
    DECLARE current_cash DECIMAL(19,4);
    SET stamat_safflower_id  = (SELECT ug.id FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
	
	START TRANSACTION;
    CALL usp_buy_item(stamat_safflower_id, 'Crusader Shields');
    CALL usp_buy_item(stamat_safflower_id, 'Frozen Blood');
    CALL usp_buy_item(stamat_safflower_id, 'Gogok of Swiftness');
    CALL usp_buy_item(stamat_safflower_id, 'Illusory Boots');
    CALL usp_buy_item(stamat_safflower_id, 'Angelic Shard');
    CALL usp_buy_item(stamat_safflower_id, 'Belt of Transcendence');
    CALL usp_buy_item(stamat_safflower_id, 'Crashing Rain');
    CALL usp_buy_item(stamat_safflower_id, 'Gem of Efficacious Toxin');
    CALL usp_buy_item(stamat_safflower_id, 'Gladiator Gauntlets');
    CALL usp_buy_item(stamat_safflower_id, 'Glowing Ore');
    CALL usp_buy_item(stamat_safflower_id, 'Last Breath');
    CALL usp_buy_item(stamat_safflower_id, 'The Crudest Boots');
    CALL usp_buy_item(stamat_safflower_id, 'The Ninth Cirri Satchel');
    CALL usp_buy_item(stamat_safflower_id, 'Wall of Man');
    SET current_cash = (SELECT ug.cash FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
    IF current_cash < 0 THEN
    ROLLBACK;
    ELSE
    COMMIT;
    END IF;
END;

CREATE PROCEDURE usp_buy_items_from_lvl_19_to_21()
BEGIN
	DECLARE stamat_safflower_id INT;
    DECLARE current_cash DECIMAL(19,4);
    SET stamat_safflower_id  = (SELECT ug.id FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
	START TRANSACTION;
    CALL usp_buy_item(stamat_safflower_id, 'Earthshatter');
    CALL usp_buy_item(stamat_safflower_id, 'TragOul Coils');
    CALL usp_buy_item(stamat_safflower_id, 'Unbound Bolt');
    CALL usp_buy_item(stamat_safflower_id, 'Ahavarion, Spear of Lycander');
    CALL usp_buy_item(stamat_safflower_id, 'Band of Hollow Whispers');
    CALL usp_buy_item(stamat_safflower_id, 'Blessed of Haull');
    CALL usp_buy_item(stamat_safflower_id, 'Cluckeye');
    CALL usp_buy_item(stamat_safflower_id, 'Devil Tongue');
    CALL usp_buy_item(stamat_safflower_id, 'Halcyons Ascent');
    CALL usp_buy_item(stamat_safflower_id, 'Reapers Fear');
    CALL usp_buy_item(stamat_safflower_id, 'The Three Hundredth Spear');
    CALL usp_buy_item(stamat_safflower_id, 'Wildwood');
    CALL usp_buy_item(stamat_safflower_id, 'Axes');
    CALL usp_buy_item(stamat_safflower_id, 'Eye of Etlich (Diablo III)');
    CALL usp_buy_item(stamat_safflower_id, 'Fire Walkers');
    CALL usp_buy_item(stamat_safflower_id, 'Hellcat Waistguard');
    CALL usp_buy_item(stamat_safflower_id, 'Leonine Bow of Hashir');
    CALL usp_buy_item(stamat_safflower_id, 'Nutcracker');
    CALL usp_buy_item(stamat_safflower_id, 'The Eye of the Storm');
    SET current_cash = (SELECT ug.cash FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
    IF current_cash < 0 THEN
    ROLLBACK;
    ELSE
    COMMIT;
    END IF;
END;

CREATE PROCEDURE usp_massive_shopping()
BEGIN
  	DECLARE selected_game_id INT;
	SET selected_game_id  = (SELECT ug.id FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');

	CALL usp_buy_items_from_lvl_11_to_12();
    CALL usp_buy_items_from_lvl_19_to_21();

    SELECT i.name FROM user_game_items AS ugi
                    INNER JOIN users_games AS ug ON ugi.user_game_id = ug.id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    INNER JOIN items AS i ON ugi.item_id = i.id
                    WHERE ug.id = selected_game_id
                    ORDER BY i.name;
    
    SELECT ug.cash FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower';
    
END;



-- 19. Buy items for user in game

CREATE PROCEDURE usp_buy_item(IN user_id INT, IN item_name VARCHAR(50))
BEGIN
	DECLARE item_price DECIMAL(19,4);
    SET item_price = (SELECT price FROM items WHERE name = item_name);
    INSERT INTO user_game_items(item_id,user_game_id)
    VALUES ((SELECT id FROM items WHERE name = item_name),user_id);
    UPDATE users_games
    SET cash = cash - item_price
    WHERE id = user_id;
END;

CREATE PROCEDURE usp_buy_items_from_lvl_11_to_12()
BEGIN
	DECLARE stamat_safflower_id INT;
    DECLARE current_cash DECIMAL(19,4);
    SET stamat_safflower_id  = (SELECT ug.id FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
	
	START TRANSACTION;
    CALL usp_buy_item(stamat_safflower_id, 'Crusader Shields');
    CALL usp_buy_item(stamat_safflower_id, 'Frozen Blood');
    CALL usp_buy_item(stamat_safflower_id, 'Gogok of Swiftness');
    CALL usp_buy_item(stamat_safflower_id, 'Illusory Boots');
    CALL usp_buy_item(stamat_safflower_id, 'Angelic Shard');
    CALL usp_buy_item(stamat_safflower_id, 'Belt of Transcendence');
    CALL usp_buy_item(stamat_safflower_id, 'Crashing Rain');
    CALL usp_buy_item(stamat_safflower_id, 'Gem of Efficacious Toxin');
    CALL usp_buy_item(stamat_safflower_id, 'Gladiator Gauntlets');
    CALL usp_buy_item(stamat_safflower_id, 'Glowing Ore');
    CALL usp_buy_item(stamat_safflower_id, 'Last Breath');
    CALL usp_buy_item(stamat_safflower_id, 'The Crudest Boots');
    CALL usp_buy_item(stamat_safflower_id, 'The Ninth Cirri Satchel');
    CALL usp_buy_item(stamat_safflower_id, 'Wall of Man');
    SET current_cash = (SELECT ug.cash FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
    IF current_cash < 0 THEN
    ROLLBACK;
    ELSE
    COMMIT;
    END IF;
END;

CREATE PROCEDURE usp_buy_items_from_lvl_19_to_21()
BEGIN
	DECLARE stamat_safflower_id INT;
    DECLARE current_cash DECIMAL(19,4);
    SET stamat_safflower_id  = (SELECT ug.id FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
	START TRANSACTION;
    CALL usp_buy_item(stamat_safflower_id, 'Earthshatter');
    CALL usp_buy_item(stamat_safflower_id, 'TragOul Coils');
    CALL usp_buy_item(stamat_safflower_id, 'Unbound Bolt');
    CALL usp_buy_item(stamat_safflower_id, 'Ahavarion, Spear of Lycander');
    CALL usp_buy_item(stamat_safflower_id, 'Band of Hollow Whispers');
    CALL usp_buy_item(stamat_safflower_id, 'Blessed of Haull');
    CALL usp_buy_item(stamat_safflower_id, 'Cluckeye');
    CALL usp_buy_item(stamat_safflower_id, 'Devil Tongue');
    CALL usp_buy_item(stamat_safflower_id, 'Halcyons Ascent');
    CALL usp_buy_item(stamat_safflower_id, 'Reapers Fear');
    CALL usp_buy_item(stamat_safflower_id, 'The Three Hundredth Spear');
    CALL usp_buy_item(stamat_safflower_id, 'Wildwood');
    CALL usp_buy_item(stamat_safflower_id, 'Axes');
    CALL usp_buy_item(stamat_safflower_id, 'Eye of Etlich (Diablo III)');
    CALL usp_buy_item(stamat_safflower_id, 'Fire Walkers');
    CALL usp_buy_item(stamat_safflower_id, 'Hellcat Waistguard');
    CALL usp_buy_item(stamat_safflower_id, 'Leonine Bow of Hashir');
    CALL usp_buy_item(stamat_safflower_id, 'Nutcracker');
    CALL usp_buy_item(stamat_safflower_id, 'The Eye of the Storm');
    SET current_cash = (SELECT ug.cash FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');
    IF current_cash < 0 THEN
    ROLLBACK;
    ELSE
    COMMIT;
    END IF;
END;

CREATE PROCEDURE usp_massive_shopping()
BEGIN
  	DECLARE selected_game_id INT;
	SET selected_game_id  = (SELECT ug.id FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower');

	CALL usp_buy_items_from_lvl_11_to_12();
    CALL usp_buy_items_from_lvl_19_to_21();

    SELECT i.name FROM user_game_items AS ugi
                    INNER JOIN users_games AS ug ON ugi.user_game_id = ug.id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    INNER JOIN items AS i ON ugi.item_id = i.id
                    WHERE ug.id = selected_game_id
                    ORDER BY i.name;
    
    SELECT ug.cash FROM users_games AS ug
					INNER JOIN users AS u ON u.id = ug.user_id
                    INNER JOIN games AS g ON g.id= ug.game_id
                    WHERE u.user_name = 'Stamat' AND g.name = 'Safflower';
    
END;