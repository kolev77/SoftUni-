CREATE DATABASE `Table_relations`;

use `Table_relations`;

CREATE TABLE employees  (
	employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	employee_name VARCHAR(50) NOT NULL
	);

CREATE TABLE projects (
	project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	project_name VARCHAR(50) NOT NULL
	);
	


-- relation MANY TO MANY 

CREATE TABLE employees_projects (
	employee_id INT,
	project_id INT,
	CONSTRAINT pk_employees_projects PRIMARY KEY(employee_id,project_id),
	CONSTRAINT fk_employees_projects_employees FOREIGN KEY(employee_id)
	REFERENCES employees(employee_id),
	CONSTRAINT fk_empoyees_projects_projects FOREIGN KEY(project_id)
	REFERENCES projects(project_id)
	);
	
	
-- relation ONE TO ONE

CREATE TABLE drivers(
  driver_id INT PRIMARY KEY,
  driver_name VARCHAR(50)
);

CREATE TABLE cars(
  car_id INT PRIMARY KEY,
  driver_id INT UNIQUE,
  CONSTRAINT fk_cars_drivers FOREIGN KEY(driver_id)
  REFERENCES drivers(driver_id)
);


	