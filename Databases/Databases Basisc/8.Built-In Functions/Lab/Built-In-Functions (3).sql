-- Calculate the area of triangles
SELECT `id`, (`a` * `h`)/2 AS 'Area'
FROM `triangles2`;

-- get PI
SELECT PI(); 

-- ABS - absolute value
SELECT ABS(-124);

-- SQRT -square root
SELECT SQRT(4);

-- POW/POWER - raise value to desired exponent
SELECT POW(2,4);
SELECT POWER(2,4);

-- example FIND the line leingth
-- Find the length of a line by given coordinates of end points
SELECT `id`,SUBSTRING(
		SQRT(POW((`X1`-`X2`),2) + POW((`Y1`-`Y2`),2)),1,7)
		as 'Length'
		from `lines`;
		

-- function CONV - Converts numbers between different number bases
		-- CONV(Value,from_base,to_base)		
SELECT CONV(122,10,16);

-- function ROUND
SELECT ROUND(12.45,1);
-- it can be negative
SELECT ROUND(12.45,-1);

-- function FLOOR(Value) and CEILING(Value)
SELECT FLOOR(4.5); -- returns 4
SELECT FLOOR(-4.5); -- returns -5

SELECT CEILING(4.5); -- returns 5
SELECT CEILING(-4.5); -- returns -4





