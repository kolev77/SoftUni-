let ch = 'x'; // string
console.log(typeof(ch));
ch++; // ch is now number
console.log(typeof(ch));
console.log(ch); // NaN

let n = "1" * 1; // number
let b = Boolean(n);
console.log(typeof(b));
console.log(b); // true

let num = 0xFF; // 255
console.log(typeof(num));
num = num + "x"; // string
console.log(typeof(num));
console.log(num); // 255x

let n = [1]; // array
console.log(typeof(n));
n++; // n is now 2 (number)
console.log(typeof(n));
