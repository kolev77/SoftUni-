// Array holding numbers
let numbers444 = [1, 2, 3, 4, 5];
// Array holding strings
let weekDays = ['Monday', 'Tuesday', 'Wednesday',
    'Thursday', 'Friday', 'Saturday', 'Sunday'];
// Array of mixed data
var mixedArr = [1, new Date(), 'hello'];
// Array of arrays (matrix)
var matrix = [
    ['0,0', '0,1', '0,2'],
    ['1,0', '1,1', '1,2'],
    ['2,0', '2,1', '2,2']];

let capitals = ['Sofia', 'Washington', 'London', 'Paris'];

for (let capital of capitals)
    console.log(capital);

for (let i in capitals)
    console.log(capitals[i]);

for (let i = 0; i < capitals.length; i++)
    console.log(capitals[i]);

let numbers1 = [1, 2, 3, 4];
console.log(numbers1.join('|')); // result: 1|2|3|4|5
numbers1.push(5);
console.log(numbers1.join('|')); // result: 1|2|3|4|5
let tail = numbers1.pop();       // tail = 5;
console.log(numbers1.join('|')); // result: 1|2|3|4
numbers1.unshift(0);
console.log(numbers1.join('|')); // result: 0|1|2|3|4
let head = numbers1.shift();     // head = 0;
console.log(numbers1.join('|')); // result: 1|2|3|4
