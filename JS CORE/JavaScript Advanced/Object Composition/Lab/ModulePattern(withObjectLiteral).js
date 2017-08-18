// modul pattern is a function that returns
// another function or object with few functions

let moduleObjWithoutClosure = {
    count: 0, // public
    increase: function(num) { return this.count += num },
    decrease: function(num) { return this.count -= num },
    value: function() { return this.count }
};
moduleObjWithoutClosure.count = 6; // the counter is accessible
console.log(moduleObjWithoutClosure.value()); // 2
console.log(moduleObjWithoutClosure.increase(5)); // 7
console.log(moduleObjWithoutClosure.decrease(1)); // 6


let module = (function() {
    let count = 0; // private
    return {
        increase: (num) => count += num,
        decrease: (num) => count -= num,
        value: () => count,
    };
}());

console.log(module.increase(5)); // 5
console.log(module.decrease(2)); // 3
console.log(module.count); // undefined (not accessible)
