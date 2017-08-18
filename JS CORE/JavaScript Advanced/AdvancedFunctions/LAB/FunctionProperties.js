function max(arr) { return arr; }
console.log(max.length); // 1 (number of arguments)
console.log(max.name); // max
console.log((function(){}).name); // (empty string)


function inner(arr) {
    console.log("Caller: " + inner.caller);
}
function outer() { inner() };
outer(); // Caller: function outer()
