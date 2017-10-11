--               String functions

-- SUBSTRING(string,pos,length)
SELECT SUBSTRING("Ivan",1,3);

-- REPLACE (String, Pattern, Replacement)
USE chinook;
SELECT *
FROM album;
SELECT
REPLACE (a.Title,'Balls','*****') AS 'Title' -- not case sensitive
FROM album AS a;


-- LTRIM (left)  and RTRIM (right)  - remove spaces from either side of string
SELECT RTRIM('GOSHE            ');
SELECT LTRIM('        GOSHE');
SELECT TRIM('           GOSHE        ');
SELECT LENGTH('Иван'); -- 8 bits
SELECT LENGTH('Ivan'); -- 4 bits
SELECT CHAR_LENGTH('Иван');
SELECT CHAR_LENGTH('Ivan');
SELECT
LEFT('GOSHE',3);
SELECT
RIGHT('GOSHE',3);

-- Problem 1
USE demo;
SELECT c.customer_id,c.first_name,c.last_name, CONCAT(
LEFT(c.payment_number,6),'**********') AS 'payment_number'
FROM customers AS c;
CREATE VIEW `v_customers_info` AS
SELECT c.customer_id,c.first_name,c.last_name, CONCAT(
LEFT(c.payment_number,6),'**********') AS 'payment_number'
FROM customers AS c;
SELECT *
FROM v_customers_info;

-- Repeat
SELECT REPEAT('GOSHI ',3);
-- Locate (Pattern, String, [Position]) - position is optianal.Returns index if it exist or null;
SELECT LOCATE('oshi','Goshi',1); 

-- Insert (String,Index,Chars to remove,New String)
SELECT
INSERT('abc',2,0,'a');
SELECT
INSERT('abc',1,2,'Goshi');


--               Math functions
SELECT t.id,(t.a * t.h) / 2 AS 'Area'
FROM triangles2 AS t;
SELECT SQRT(49);
SELECT POW(2,3);
SELECT l.id,
(SQRT(POW((l.x1 - l.x2),2) + POW((l.y1 - l.y2),2))) AS 'Length'
FROM `lines` AS l;

-- Convert (value,from_base,to_base)
SELECT CONV(24,10,16);

-- Round(Value,Precision)
SELECT ROUND(1234.123,1);
SELECT ROUND(1234.123,-1);

-- Floor
SELECT FLOOR(24.5); -- 24
SELECT FLOOR(-24.5); -- 24
SELECT CEILING(24.5);
SELECT CEILING(-24.5);

-- Problem Pallets
SELECT CEILING(CEILING(p.quantity / p.box_capacity)/p.pallet_capacity) AS 'Number of pallets'
FROM products AS p;


-- Sign
SELECT SIGN(10);
SELECT SIGN(-10);

-- Random function
SELECT RAND();
SELECT FLOOR(RAND()*10); -- Random int
SELECT FLOOR(7 + RAND()* (12-7)); -- i <= R < j  , i = 7, j = 12

-- Dates functions
USE chinook;
SELECT i.InvoiceId,i.Total, EXTRACT(QUARTER
FROM i.InvoiceDate) AS 'Quarter', EXTRACT(MONTH
FROM i.InvoiceDate) AS 'Month', EXTRACT(YEAR
FROM i.InvoiceDate) AS 'Year', EXTRACT(DAY
FROM i.InvoiceDate) AS 'Day'
FROM invoice AS i;



-- TIMESTAMPDIFF (Part, firstDate,secondDate) - part can be any part and format of date or time
SELECT e.EmployeeId,e.FirstName, TIMESTAMPDIFF(YEAR,e.HireDate,'2010-12-14') AS 'Years in service'
FROM employee AS e;

-- DATE_FORMAT(Date,Format)
SELECT DATE_FORMAT('2017-10-17','%y %b %D') AS 'Date';
SELECT DATE_FORMAT('2017-10-17','%y-%M-%d') AS 'Date';
SELECT DATE_FORMAT(NOW(),'year: %y month: %b day: %D') AS 'Date';


-- Regular Expressions

-- Like '%pattern'/'pattern%' - find words starting or eding with
USE soft_uni;
SELECT e.employee_id,e.first_name,e.last_name
FROM employees AS e
WHERE e.first_name LIKE 'Ro%';
SELECT e.employee_id,e.first_name,e.last_name
FROM employees AS e
WHERE e.first_name LIKE '%obe%';
SELECT e.employee_id,e.first_name,e.last_name
FROM employees AS e
WHERE e.first_name LIKE 'Ro_'; -- matches with only one more symbol
SELECT e.employee_id,e.first_name,e.last_name
FROM employees AS e
WHERE e.first_name LIKE 'G%' AND e.last_name LIKE 'G%';
SELECT *
FROM addresses AS a
WHERE a.address_text LIKE '___ %';

-- There are special symbols which must be escaped
USE chinook;
SELECT t.TrackId,t.Name
FROM track AS t
WHERE t.Name LIKE '%wer\!%';  -- '!' must be scaped with '\' 

use soft_uni;
SELECT e.employee_id,e.first_name,e.last_name
FROM employees as e
WHERE e.first_name REGEXP '^\[^K\]{3}\$';

