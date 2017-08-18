-- Wildcard Characters
-- Supported characters include
-- '%' any string, including zero-length
-- '_' any single character

-- '\' specify prefix to treat special characters as normal

SELECT `TrackID`, `Name`
	FROM `Track`
	WHERE `Name` LIKE 'Ro%'; -- starting with 'Ro'
	
	
	
SELECT `TrackID`, `Name`
	FROM `Track`
	WHERE `Name` LIKE '%RO'; -- ending with 'Ro'
	
		
SELECT `TrackID`, `Name`
	FROM `Track`
	WHERE `Name` LIKE 'RO____'; -- starting with 'Ro'+ exactly 4 symbols
	
-- function REGEXP(); 
SELECT `TrackID`, `Name`
	FROM `Track`
	WHERE `Name` REGEXP '^\[^G \]{3}\$';
	
	