'use strict'
function outer() {
    console.log(this); // Object {name: "Peter"}
    function inner() {
        console.log(this); // Window
    }
    inner();
}
let obj = { name: 'Peter', f: outer }
obj.f();
