-- Task 1 -  Find pallets
SELECT CEILING(CEILING(p.quantity/p.box_capacity) / p.pallet_capacity) AS 'Number of pallets'
FROM `products` as p;

-- function SIGN() - returns (1/-1)
SELECT SIGN(15);
SELECT SIGN(-15);

-- function RAND() - returns random number betweeen 0 and 1
SELECT RAND();
-- If we put every time same number as seed, RAND(seed)
-- the random order will be the same
SELECT*FROM `customers`
ORDER BY RAND(1);

-- Generate random num between 7 and 12
SELECT FLOOR(7+ RAND() * (12-7));

-- Work with DATE_TIME
-- Extract different parts 
USE `chinook`;
SELECT i.InvoiceId, i.Total,
	EXTRACT(quarter FROM i.InvoiceDate) AS 'Quarter',
	EXTRACT(month FROM i.InvoiceDate) AS 'Month',
	DATE_FORMAT(i.InvoiceDate,'%Y') as 'Year', 
	EXTRACT(day FROM i.InvoiceDate) as 'Day'
FROM `invoice` as i;

-- using DATE_FORMAT 
SELECT i.InvoiceId, i.Total,
	EXTRACT(quarter FROM i.InvoiceDate) AS 'Quarter',
	EXTRACT(month FROM i.InvoiceDate) AS 'Month',
	EXTRACT(year FROM i.InvoiceDate) as 'Year', 
	EXTRACT(day FROM i.InvoiceDate) as 'Day'
FROM `invoice` as i;

-- timestampdiff(unit,date1,date2) Give us time between two dates
SELECT e.EmployeeId, e.FirstName, e.LastName,
		 TIMESTAMPDIFF(year, e.HireDate, NOW())
		 AS 'Years In Service'
FROM `employee` as `e`;

