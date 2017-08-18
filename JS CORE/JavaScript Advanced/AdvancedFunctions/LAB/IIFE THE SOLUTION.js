let arr = [10, 20, 30];
let sum = 0;
for (let x of arr)
    sum += x;
console.log(sum);

// "sum" and "arr" remain visible in the current scope


function sumArray(arr) {
    let sum = 0;
    for (let x of arr)
        sum += x;
    console.log(sum);
}
sumArray([10, 20, 30]);
// The function "sumArray" remains in the current scope
// The "sum" variable is "hidden" in the function


(function(arr) {
    let sum = 0;
    for (let x of arr)
        sum += x;
    console.log(sum);
})([10, 20, 30])

// Nothing remains in the current scope
// "sum" and "arr" are "hidden" in annonymous function
