SELECT *FROM mountains;

SELECT *FROM peaks;
-- Peaks in Rila

SELECT m.mountain_range,p.peak_name, p.elevation 
FROM `peaks` AS `p`
JOIN `mountains` AS `m`
ON m.id = p.mountain_id  -- join condition
WHERE m.mountain_range = 'Rila'
ORDER BY p.elevation DESC;



SELECT * FROM messages;
SELECT * FROM users;

--  DELETE CASCADE

DELETE FROM users
WHERE users.id = 1;

DROP TABLE `messages`;

CREATE TABLE messages(
	message_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(255) NOT NULL,
	user_from INT,
	user_to INT,
	ref_id INT,
	CONSTRAINT fk_messages_users_from FOREIGN KEY(user_from)
	REFERENCES users(id) ON DELETE CASCADE,
	CONSTRAINT fk_messages_users_to FOREIGN KEY(user_to)
	REFERENCES users(id) ON DELETE CASCADE,
	CONSTRAINT fk_messages_messages FOREIGN KEY(ref_id)
	REFERENCES messages(message_id) ON DELETE CASCADE);
	
	
-- UPDATE CASCADE
CREATE TABLE drivers(
  driver_id INT PRIMARY KEY,
  driver_name VARCHAR(50)
);

CREATE TABLE cars(
  id INT PRIMARY KEY,
  driver_id INT,
  CONSTRAINT fk_car_driver FOREIGN KEY(driver_id)
  REFERENCES drivers(driver_id) ON UPDATE CASCADE);

SELECT * FROM cars;
SELECT * FROM drivers;

UPDATE drivers
SET drivers.driver_id = 8
WHERE drivers.driver_id = 2;


