/**
 * Created by Rostislav on 17.6.2016 г..
 */
let obj = { name : "SoftUni", age : 2 }
console.log(obj); // Object {name: "SoftUni", age: 2}
obj['site'] = "http://www.softuni.bg"
obj.age = 10
obj['name'] = "Software University"
console.log(obj) // Object {name: "Software University", age: 10, site: "http://www.softuni.bg"}
delete obj.name
delete obj.site
console.log(obj) // Object {age: 10}
