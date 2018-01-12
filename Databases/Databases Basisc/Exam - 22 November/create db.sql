CREATE DATABASE sofia_project;
USE sofia_project;

DROP DATABASE sofia_project;

CREATE TABLE users(
	id INT(11) UNIQUE PRIMARY KEY ,
	username VARCHAR(30) UNIQUE,
	`password` VARCHAR(50) NOT NULL,
	name VARCHAR(50),
	gender VARCHAR(1),
	birthdate DATETIME,
	age INT(11),
	email VARCHAR(50) NOT NULL
);


CREATE TABLE departments(
	id INT(11) UNIQUE  PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE employees (
	id INT(11) UNIQUE PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	gender VARCHAR(1),
	birthdate DATETIME,
	age INT(11),
	department_id INT(11),
	CONSTRAINT fk_employee_dep 
	FOREIGN KEY(department_id)
	REFERENCES departments(id)
);

CREATE TABLE categories (
	id INT(11) UNIQUE  PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	department_id INT(11),
	CONSTRAINT fk_category_dep
	FOREIGN KEY(department_id)
	REFERENCES departments(id)
);

CREATE TABLE `status` (
	id INT(11) UNIQUE  PRIMARY KEY,
	label VARCHAR(30) NOT NULL
);


CREATE TABLE reports (
	id INT(11) UNIQUE  PRIMARY KEY AUTO_INCREMENT,
	category_id INT(11),
	status_id INT(11),
	open_date DATETIME,
	close_date DATETIME,
	description VARCHAR(200),
	user_id INT(11),
	employee_id INT(11),
	CONSTRAINT fk_report_category
	FOREIGN KEY(category_id) REFERENCES categories(id),
	CONSTRAINT fk_report_status
	FOREIGN KEY(status_id) REFERENCES `status`(id),
	CONSTRAINT fk_report_user
	FOREIGN KEY(user_id) REFERENCES users(id),
	CONSTRAINT fk_report_employee
	FOREIGN KEY(employee_id) REFERENCES employees(id)
);