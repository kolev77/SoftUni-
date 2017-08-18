// The || operators returns the leftmost "true" value:
let t = false || 0 || '' || 5 || 'hi' || true;
console.log(t); // 5

//The && operators returns the leftmost "false" value:

let val = true && 'yes' && 5 && null && false;
console.log(val); // null


var a = 5;
var b = 4;
console.log(a == b); // false
console.log(a != b); // true
console.log(a >= b); // true
console.log(a < "5.5"); // true
console.log(0 == ""); // true
console.log(0 == []); // true
console.log(0 === ""); // false
console.log(3 !== "3"); // true
