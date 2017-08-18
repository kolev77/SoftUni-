'use strict';
let ch = 'x';
console.log(typeof(ch) + ' ' + ch); // string x
let str = "hello";
console.log(typeof(str) + ' ' + str); // string hello
console.log(str.length); // 5
console.log(str[0]); // h
str[0] = 's'; // Beware: no error, but str stays unchanged!
console.log(str); // hello
console.log(str[10]); // undefined
