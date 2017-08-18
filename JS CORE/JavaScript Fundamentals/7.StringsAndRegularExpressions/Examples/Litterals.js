

'\d+' //matches digits

'\D+' // matches non-digits

'\w+' // matches letters (Unicode)

'\W+' // matches non-letters

'\+\d{1,3}([ -]*[0-9]){6,}' // matches international phone,
                            // e.g. +359 2 123-456

'\b' // matches word boundary[граница]

'\b\w+\b' // matches only words, without white space between them
'\s\w+\s' // matches words, with white space before and after them

'.' // matches all symbols != new line

'\\' // special symbols must be prefixed

'^'  // beginning of the string
'$' // end of the string

'[A-Z]' // matches all big letters
'[^A-Z]' // matches all symbols except big letters

'(They|do)' // matches first or second word
'o(u|s)' // matches all 'o's before 'u' or 's'

'are ([a-z]+) powerful'  // matches word between two words " are VERY powerful "

'\((.+)\)' // matches everything between  the brackets

'[0-9]' // matches digits
'[0-9]{2}' // matches  two  digits
'[0-9]{1,3}' // matches  from 1 to 3  digits
'[0-9]+' // matches as many times as possible (greedy)
'[0-9]+?' // matches all digits one by one (lazy)
'[0-9]*' // matches digits ( 0 or inf.)
'[0-9]?' // matches digits ( 0 or 1)