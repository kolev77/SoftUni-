function multiply(a, b) {
    return a * b;
}
console.log(multiply(2, 3)); // 6 == 2 * 3
console.log(multiply(2)); // NaN == 2 * undefined
console.log(multiply(5, 6, 7)); // 30 = 5 * 6

let print = function(x) { console.log(x) };
[10, 20, 30].forEach(print)

let sum = 0;
[15, 201, 320].forEach(function(x) {
    sum += x;
});
console.log(sum) // 536


(function(text) { alert(text) })("hello");

(function blockScope() {
    // console.log(x); // error!
    let x = 5; console.log(x); // 5
    for (let x = 20; x < 30; x++)
        console.log(x) // 20 … 29
    console.log(x) // 5
    x = 10; console.log(x) // 10
    // let x = 5; // error!
}) ()

