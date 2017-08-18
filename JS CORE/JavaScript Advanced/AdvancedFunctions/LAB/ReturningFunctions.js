
let f = (function() {
    let counter = 0;
    return function () {
        console.log(++counter);
    }
})();

f();
f();
f();
f();
console.log(f);

let a = (function () {
    let counter = 0;
    console.log("start IIFE");
    return function () {
        console.log("next IIFE");
        console.log(++counter);
    }
})();

a();
a();
a();
a();