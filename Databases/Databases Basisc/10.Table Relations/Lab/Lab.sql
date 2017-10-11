CREATE DATABASE example_constraints;
use example_constraints;
-- 1.Problem
CREATE TABLE mountains(
  mountain_id INT PRIMARY KEY,
  mountain_name VARCHAR(50)
);
CREATE TABLE peaks(
  peak_id INT PRIMARY KEY,
  mountain_id INT,
  CONSTRAINT fk_peaks_mountains 
  FOREIGN KEY (mountain_id)  REFERENCES mountains(mountain_id));


-- 2.Problem

CREATE TABLE employees(
  employee_id INT PRIMARY KEY,
    employee_name VARCHAR(50)
);

CREATE TABLE projects(
	project_id INT PRIMARY KEY,
	project_name VARCHAR(50)
);


CREATE TABLE employees_projects(
     employee_id INT,
	  project_id INT,
	  -- set double primary key
	  CONSTRAINT pk_employees_projects
	  PRIMARY KEY(employee_id, project_id),
	  
	
	  CONSTRAINT fk_employees_projects_employees
	  FOREIGN KEY(employee_id)
	  REFERENCES employees(employee_id),
	  
	  CONSTRAINT fk_employees_projects_projects
	  FOREIGN KEY(project_id)
	  REFERENCES projects(project_id)
);



-- 3.Problem

CREATE TABLE drivers(
  driver_id INT PRIMARY KEY,
  driver_name VARCHAR(50)
);

CREATE TABLE cars(
  car_id INT PRIMARY KEY,
  driver_iexample_constraintsd INT UNIQUE,   -- with relation -> one to one 
  CONSTRAINT fk_cars_drivers 
  FOREIGN KEY  (driver_id) REFERENCES drivers(driver_id)
);


-- 4.Problem
use geography;

SELECT m.mountain_range, p.peak_name, p.elevation
FROM peaks AS p
	JOIN mountains AS m
		ON p.mountain_id = m.id
		AND m.mountain_range = 'R' 
	ORDER BY p.elevation DESC;

