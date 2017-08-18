//Assign a value to variable: =, +=, -=, *=, /=, |=, ...
let y = 4; console.log(y *= 2); // 8
let z = y = 3; // y=3 and z=3
console.log(z += 2); // 5
let unknown_value;
console.log(unknown_value); // undefined

//Conditional ternary operator ? :
console.log((new Date()).getDay() % 2 == 0 ?
    "even date" : "odd date");
