// function f() {
//     console.log(this);
// }
//add(); // Window ("this" is the global context)


function b() {
    'use strict';
    console.log(this);
}
b(); // undefined ("this" is missing)


function func() {
    'use strict'
    console.log(this);
}
let obj = {
    name: 'Peter',
    f: func
};
obj.f(); // Object {name: "Peter"}
func();


function Car() {
    console.log(this);
}
let car = new Car(); // Car {}
