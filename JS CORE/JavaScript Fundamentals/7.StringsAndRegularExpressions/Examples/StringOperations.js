let str1 = "I am JavaScript developer";
console.log(str1.indexOf("Java")); // -1
console.log(str1.indexOf("java")); // 5


console.log('\n')
let str2 = "I am JavaScript developer";
let sub2 = str2.substr(5); // ubstr(start, length)
console.log(sub2); // JavaScript developer
console.log('\n')


let str = "I am JavaScript developer";
let sub = str.substring(5, 9); // startIndex, endIndex
console.log(sub); // Java
