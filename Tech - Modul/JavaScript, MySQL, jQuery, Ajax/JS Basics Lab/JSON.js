let obj = { name : "SoftUni", age : 2 }
let str = JSON.stringify(obj)
console.log(str) // {"name":"SoftUni","age":2}

let str1 = "{\"name\":\"Nakov\",\"age\":24}"
let obj1 = JSON.parse(str)
console.log(obj) // Object {name: "Nakov", age: 24}
