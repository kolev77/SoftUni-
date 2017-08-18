-- SELF relation
CREATE TABLE `employees` (
	employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	employee_name VARCHAR(50),
	manager_id INT,
	CONSTRAINT fk_employees_employees FOREIGN KEY(manager_id)
	REFERENCES employees(employee_id));
	

-- Some kind of db for chat app 

CREATE TABLE users ( 
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(50) NOT NULL
	);
	
	

CREATE TABLE messages(
	message_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(255) NOT NULL,
	user_from INT,
	user_to INT,
	ref_id INT,
	CONSTRAINT fk_messages_users_from FOREIGN KEY(user_from)
	REFERENCES users(id),
	CONSTRAINT fk_messages_users_to FOREIGN KEY(user_to)
	REFERENCES users(id),
	CONSTRAINT fk_messages_messages FOREIGN KEY(ref_id)
	REFERENCES messages(message_id));
	
	INSERT INTO users(username)
	VALUES ("Vanka"),("MACKATA"),("Pesho");
	
	INSERT INTO messages (content,user_from,user_to)
	VALUES ('Zdravei',1,2);
	
	INSERT INTO messages (content,user_from,user_to,ref_id)
	VALUES ('Zdravei,kak si ?',2,1,1);
	
	SELECT * FROM messages;
	
	