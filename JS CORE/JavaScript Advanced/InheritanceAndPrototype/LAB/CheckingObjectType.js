class Person {
    constructor(name, email) {
        this.name = name;
        this.email = email;
    }
}
class Teacher extends Person {
    constructor(name, email, subject) {
        super(name, email);
        this.subject = subject;
    }
}
let p = new Person("Pesho","pesho@hit.bg");
console.log(p.constructor.name);
// Person
let t = new Teacher("Pesho","pp@hit.bg","PHP");
console.log(t instanceof Person)
// true
