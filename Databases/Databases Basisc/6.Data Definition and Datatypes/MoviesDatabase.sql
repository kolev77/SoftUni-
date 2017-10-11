create database movies;
use movies;

create table directors(
	id int not null primary key auto_increment,
	director_name varchar(50) not null,
	notes text);
	
create table genres(
	id int not null primary key auto_increment,
	genre_name varchar(50) not null,
	notes text);
	
create table categories(
	id int not null primary key auto_increment,
	category_name varchar(50) not null,
	notes text);
	
create table movies(
	id int not null primary key auto_increment,
	title varchar(50) not null,
	director_id int,
	copyright_year date,
	length double(6,2),
	genre_id int,
	category_id int,
	rating int,
	notes text);
	
insert into directors(director_name,notes)
values ('Georgi', 'Some text'),
('Ivan', 'Some text'),
('Aneta', 'Some text'),
('Daniela', 'Some text'),
('Petar', 'Some text');

insert into categories(category_name,notes)
values ('Crimi', 'Some text'),
('Adventure', 'Some text'),
('Comedy', 'Some text'),
('Action', 'Some text'),
('Drama', 'Some text');

insert into genres(`genre_name`, `notes`)
values ('Crimi', 'Some text'),
('Adventure', 'Some text'),
('Comedy', 'Some text'),
('Action', 'Some text'),
('Drama', 'Some text');

insert into movies(`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
values('Movie 1', 1, CURDATE(), 2.22, 2, 3, 10, 'Some text'),
('Movie 2', 2, CURDATE(), 3.32, 1, 2, 9, 'Some text'),
('Movie 3', 3, CURDATE(), 4.52, 5, 1, 8, 'Some text'),
('Movie 4', 4, CURDATE(), 6.72, 4, 5, 7, 'Some text'),
('Movie 1', 5, CURDATE(), 9.22, 3, 4, 6, 'Some text');