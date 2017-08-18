let str = "I like    JS";
let tokens = str.split(' ');
console.log(tokens); // ["I", "like", "", "", "", "JS"]
tokens = tokens.filter(s => s!='');
console.log(tokens); // ["I", "like", "JS"]
console.log(tokens.join(' ')); // I like JS


let tokens = str.split(' ').filter(s=> s!= '').join(' '); // on 1 row

let s = "I like JS. JS is cool";

console.log(s.replace('JS', "C#")); // I like C#. JS is cool
console.log(s.replace(/JS/g, "C#")); // I like C#. C# is cool
