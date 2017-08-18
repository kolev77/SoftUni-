-- FUNCTIONS
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

SELECT p.project_id, 
	DATE(p.start_date) AS 'start_date', 
       DATE(p.end_date) AS 'end_date',
	udf_project_weeks(p.start_date, p.end_date) AS 'project_weeks'
  FROM projects AS p;
  
DELIMITER $$
CREATE FUNCTION udf_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level VARCHAR(10);
		IF (salary < 30000) THEN
			SET salary_level := 'Low';
		ELSEIF(salary >= 30000 AND salary <= 50000) THEN
			SET salary_level := 'Average';
		ELSE
			SET salary_level := 'High';
	END IF;
	RETURN salary_level;
END$$


SELECT e.first_name, e.last_name, e.salary,
 udf_get_salary_level(e.salary) AS 'salary_level'FROM employees AS e;
 
 
 -- Transactions
DELIMITER $$

-- Procedure

DELIMITER $$
CREATE PROCEDURE usp_select_employees_by_seniority() 
BEGIN
  SELECT * 
  FROM employees
  WHERE ROUND((DATEDIFF(NOW(), hire_date) / 365.25)) < 15;
END $$

DELIMITER ;
CALL usp_select_employees_by_seniority();
DROP PROCEDURE usp_select_employees_by_seniority;

-- using params
DELIMITER $$
CREATE PROCEDURE
usp_select_employees_by_seniority(min_years_at_work INT)
BEGIN
  SELECT first_name, last_name, hire_date,
    ROUND(DATEDIFF(NOW(),DATE(hire_date)) / 365.25,0) AS 'years'
  FROM employees
  WHERE ROUND(DATEDIFF(NOW(),DATE(hire_date)) / 365.25,0) > min_years_at_work
  ORDER BY hire_date;
END $$

CALL usp_select_employees_by_seniority(16);


-- OUTPUT
DELIMITER $$
CREATE PROCEDURE usp_add_numbers
(first_number INT,
second_number INT,
   OUT result INT)
BEGIN
   SET result = first_number + second_number;
END $$
DELIMITER ;

SET @answer=0;
CALL usp_add_numbers(5, 6,@answer);
SELECT @answer;

-- 11



-- PRROBLEM: WITHDRAW

DELIMITER $$

CREATE PROCEDURE usp_withdraw_money (account_id INT, money_amount DECIMAL)
BEGIN
START TRANSACTION;
	UPDATE accounts
    SET balance = balance - money_amount
	WHERE account_holder_id = account_id;
    
	IF(account_id NOT IN ( SELECT a.account_holder_id FROM accounts AS a))
    THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid Account';
    ROLLBACK;
    ELSE
    COMMIT;
    END IF;
END $$

DELIMITER ;
CALL usp_withdraw_money(2,113);
CALL usp_withdraw_money(12412412,113); -- error msg


-- ТRIGGERS

CREATE TABLE employees_projects_history(
	employee_id INT,
    project_id INT);


DELIMITER $$
CREATE TRIGGER tr_delete_records
AFTER DELETE
ON employees_projects
FOR EACH ROW
BEGIN
	INSERT INTO employees_projects_history
	      (employee_id, project_id)
	VALUES(old.employee_id, old.project_id);  -- old/new are key words
END $$

DELIMITER ;

DELETE FROM employees_projects
WHERE employee_id = 3;



-- SECOND EXAMPLE
CREATE TABLE employees_projects_history(
	employee_id INT,
    project_id INT,
    employee_old_salary DECIMAL(19,4),
    employee_new_salary DECIMAL(19,4));

DELIMITER $$
CREATE TRIGGER tr_update_records
AFTER UPDATE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO employees_projects_history
	      (employee_id,employee_old_salary,employee_new_salary)
	VALUES(old.employee_id, old.salary, new.salary);  -- old/new are key words
END $$

DELIMITER ;

UPDATE employees SET salary = 123123
WHERE employee_id = 1;

