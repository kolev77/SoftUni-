
// Closure is the possibility of function to
// keep data in her parent function
function counterClosure() {
    let counter = 0;             // closure
    function getNextCount() {
        console.log(++counter);
    };
    return getNextCount;
}
let count = counterClosure();
count(); // 1
count(); // 2
count(); // 3
count(); // 4
count(); // 5

console.log("_______________\n");
// SHORTER SYNTAX WITH  " IIFE "
let counter1 = (function() {
    let num = 0;
    return function() {
        console.log(++num);
    };
})();
counter1(); // 1
counter1(); // 2
counter1(); // 3

console.log("_______________\n");



let counter = (() => {
    let num = 0;
    return () =>
        console.log(++num);
})();
counter(); // 1
counter(); // 2
counter(); // 3
counter(); // 4

