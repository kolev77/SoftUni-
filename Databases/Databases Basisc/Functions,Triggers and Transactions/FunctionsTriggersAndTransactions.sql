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