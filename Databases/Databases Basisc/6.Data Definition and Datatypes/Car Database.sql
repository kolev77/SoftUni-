CREATE DATABASE `car_rental_base`; USE `car_rental_base`;
CREATE TABLE `categories`(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	category VARCHAR(30) NOT NULL,
	daily_rate DOUBLE(5,2),
	weekly_rate DOUBLE(5,2),
	monthly_rate DOUBLE(5,2),
	weekend_rate DOUBLE(5,2));
CREATE TABLE `cars`(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	plate_number INT NOT NULL,
	make VARCHAR(30) NOT NULL,
	model VARCHAR(30),
	car_year INT,
	category_id INT,
	doors INT,
	picture MEDIUMBLOB,
	car_condition VARCHAR(30),
	available ENUM('true','false') NOT NULL);
CREATE TABLE `employees`(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	title VARCHAR(30),
	notes TEXT);
CREATE TABLE `customers`(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	driver_licence_number INT NOT NULL,
	full_name VARCHAR(60) NOT NULL,
	adress VARCHAR(40),
	zip_code INT,
	notes TEXT);
CREATE TABLE rental_orders(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	employee_id INT NOT NULL,
	customer_id INT NOT NULL,
	car_id INT NOT NULL,
	car_condition VARCHAR(30),
	tank_level INT,
	kilometrage_start INT NOT NULL,
	kilometrage_end INT NOT NULL,
	total_kilometrage INT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	total_days INT NOT NULL,
	rate_applied DOUBLE(5,2),
	tax_rate DOUBLE(5,2),
	order_status VARCHAR(30),
	notes TEXT);
	
INSERT INTO `employees`(id,first_name,last_name,title,	notes) VALUES (1,'Georgi','Petrov','IT specialist', NULL),
		(2,'Pesho','Cvetkov','IT support', NULL),
		(3,'Gergana','Ivanova','IT specialist', NULL);
		
INSERT INTO `categories`(`id`,`category`,`daily_rate`,`weekly_rate`,`monthly_rate`,`weekend_rate`) VALUES (1,"Sport",14.2,4.3,2.4,7.6),
		 (2,"Comfort",12.2,7.5,2.4,7.6),
		 (3,"Family",10.2,4.4,2.4,4.6);
		 
INSERT INTO `cars`(`id`,`plate_number`,`make`,`model`,`car_year`,`category_id`,`doors`,`picture`,`car_condition`,`available`) VALUES (1,2405,'BMW',"330xd",2014,1,4, NULL,"Perfect !", TRUE),
		 (2,2411,'MERCEDES',"330xd",2014,1,4, NULL,"Perfect !", TRUE),
		 (3,2444,'AUDI',"330xd",2014,1,4, NULL,"Perfect !", TRUE);
		 
INSERT INTO `customers`(id,driver_licence_number,full_name,adress,zip_code,notes) VALUES (1,124124,'Georgi Petkov','Bulgaria,Varna-bl.124',9000, NULL),
(2,441124,'Mariana Ivanova','Bulgaria,Sofia-bl.124',9000, NULL),
(3,766124,'Teodora Petkova','Bulgaria,Plovdiv-bl.124',9000, NULL);

INSERT INTO `rental_orders`(id,employee_id,customer_id,car_id,car_condition,tank_level,kilometrage_start,
				 kilometrage_end,total_kilometrage,start_date,end_date,total_days,rate_applied,
				 tax_rate,order_status,notes) VALUES (1,1,1,1,"Perfect",40,10444,11000,1000,'2017-02-03','2017-03-03',31,7.12,150.44,'complete', NULL),
(2,2,2,2,"Perfect",40,10444,11000,1000,'2017-02-03','2017-03-03',31,7.12,150.44,'complete', NULL),
(3,3,3,3,"Perfect",40,10444,11000,1000,'2017-02-03','2017-03-03',31,7.12,150.44,'complete', NULL);