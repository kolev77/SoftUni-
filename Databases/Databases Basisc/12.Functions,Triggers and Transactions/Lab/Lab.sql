DELIMITER $$
CREATE FUNCTION udf_project_weeks (start_date DATETIME, end_date DATETIME)
RETURNS INT
BEGIN
	DECLARE project_weeks INT;
	IF(end_date IS NULL) THEN
		SET end_date := NOW();	
	END IF;
	SET project_weeks := DATEDIFF(DATE(end_date), DATE(start_date)) / 7;
	
	RETURN project_weeks;
END $$

DELIMITER ;

SELECT udf_project_weeks(DATE('2005/1/1'),DATE('2005/1/4')) AS 'weeks'; 


-- 1.Problem
DELIMITER $$
CREATE FUNCTION udf_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE result VARCHAR(10);
	IF(salary < 30000) THEN
	SET result := 'Low';
	ELSEIF(salary <= 50000) THEN
	SET result := 'Average';
	ELSE 
	SET result := 'High';
	END IF;
	RETURN result;
END$$
DELIMITER ;

-- TEST
SELECT e.first_name, e.salary, udf_get_salary_level(e.salary) AS 'Salary Level' 
FROM employees AS e;


-- Transactions Syntax


-- Stored Procedures without parameters
use soft_uni;
DELIMITER $$
CREATE PROCEDURE usp_select_employees_by_seniority() 
BEGIN
  SELECT * 
  FROM employees
  WHERE ROUND((DATEDIFF(NOW(), hire_date) / 365.25)) < 15;
END $$

DELIMITER $$
CREATE PROCEDURE usp_update_employees_by_seniority() 
BEGIN
  UPDATE employees
  SET middle_name = 'GOSHO'
  WHERE ROUND((DATEDIFF(NOW(), hire_date) / 365.25)) < 15
  AND first_name = 'Michael'
  ;
END $$


CALL usp_update_employees_by_seniority();
CALL usp_select_employees_by_seniority();
DROP PROCEDURE usp_update_employees_by_seniority;


-- Stored procedures with parameters
DELIMITER $$
CREATE PROCEDURE usp_select_employees_by_seniority_year(min_years_at_work INT)
BEGIN
  SELECT first_name, last_name, hire_date,
    ROUND(DATEDIFF(NOW(),DATE(hire_date)) / 365.25,0) AS 'years'
  FROM employees
  WHERE ROUND(DATEDIFF(NOW(),DATE(hire_date)) / 365.25,0) > min_years_at_work
  ORDER BY hire_date;
END $$

CALL usp_select_employees_by_seniority_year(17);

-- Returning values using OUTPUT parameters
DELIMITER $$
CREATE PROCEDURE usp_add_numbers(first_num INT,second_num INT,OUT result INT)
BEGIN
	SET result = first_num + second_num;
END$$

SET @answer = 0;
CALL usp_add_numbers(5,6,@answer);
SELECT @answer;


-- 1.Problem 
use bank_db;
DROP PROCEDURE usp_withdraw_money;

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money  (IN account_id INT, IN money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
	UPDATE accounts 
	SET accounts.balance = accounts.balance-money_amount
	WHERE accounts.id = account_id;	

  IF(account_id NOT IN(SELECT a1.id FROM accounts AS a1))
  THEN 
  SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid ID ! ';
  ROLLBACK;
  END IF;
	 ROLLBACK;
COMMIT;	
END$$
DELIMITER ;

CALL usp_withdraw_money(12412,555);
		
		
-- Triggers
use soft_uni;
CREATE TABLE employees_projects_history(
	employee_id INT,
	project_id INT);
	
DELIMITER $$
CREATE TRIGGER tr_delete_records
AFTER DELETE
ON employees_projects
FOR EACH ROW
BEGIN 
	INSERT INTO employees_projects_history(employee_id,project_id)
	VALUES(old.employee_id,old.project_id);
END$$

DELETE FROM employees_projects
WHERE employee_id = employees_projects_history1;