create table users(
	id int unique auto_increment primary key,
	username  varchar(30) unique not null,
	password varbinary(26) not null,
	profile_picture mediumblob,
	last_login_time timestamp,
	is_deleted enum('true','false') not null
	);
	

insert into users(id,username,password,profile_picture,last_login_time,is_deleted)
values 
(1,"Goshe","A21312asda",null,NOW(),'false'),
(2,"Moshe","A21312asdasda",null,NOW(),'false'),
(3,"Toshe","A213dd12asda",null,NOW(),'false'),
(4,"Mariq","A213ads12asda",null,NOW(),'false'),
(5,"Gerganka","A213ddd2asda",null,NOW(),'false');

alter table users
drop primary key,
add constraint pk_users 
primary key(id,username);
\
alter table users
modify column last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP;


alter table users
drop primary key,
add constraint pk_users 
primary key(id),
add users pk_users
unique(username);




