SELECT * FROM `customers`;

SELECT char_length(`payment_number`) as L
 FROM `customers`
 ORDER BY L DESC;
 
SELECT c.customer_id as `id`, c.first_name, c.last_name,
 CONCAT(LEFT(payment_number,6),'*********') as payment_number
FROM `customers` AS c;


CREATE VIEW v_public_payment_info AS SELECT c.customer_id as `id`, c.first_name, c.last_name,
 CONCAT(LEFT(payment_number,6),'*********') as payment_number
FROM `customers` AS c;

 -- create and select view
SELECT * FROM v_public_payment_info; 


-- substring and concat using UPPER func
SELECT CONCAT(upper(SUBSTRING('abc',1,1)), substring('abc',2)); 

-- reverse string
SELECT REVERSE ('Polina');

-- repeat 
SELECT REPEAT('ABDIIIII ',2);
-- repeat 
SELECT REPEAT (REVERSE('Polinda '),2);

-- function LOCATE(Pattern, String,[Position]) 
-- if omitted, begins at 1

SELECT LOCATE('abc','dabc');

-- function INSERT - insert substring at specific position
-- INSERT(String,Position,Length, Substring)
--              [start] [to remove] [new string]
SELECT INSERT('abc',1,2,'a');

