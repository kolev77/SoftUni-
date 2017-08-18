class Person {
    constructor(name, email) {
        this.name = name;
        this.email = email;
    }
    toString() {
        let className = this.constructor.name;
        return `${className} (name: ${this.name}, email: ${this.email})`;
    }
}

class Teacher extends Person {
    constructor(name, email, subject) {
        super(name, email);
        this.subject = subject;
    }
    toString() {
        let baseStr = super.toString().slice(0, -1); // slice is used for removing the last symbol
        return baseStr + `, subject: ${this.subject})`;
    }
}

class Student extends Person {
    constructor(name, email, course) {
        super(name, email);
        this.course = course;
    }
    toString() {
        let baseStr = super.toString().slice(0, -1);
        return baseStr + `, course: ${this.course})`;
    }
}
console.log(Object.getPrototypeOf(Teacher) == Person);
// true (class prototype holds the parent class)

console.log(Object.getPrototypeOf(Person) == Function.prototype); // true


let p = new Person("Maria", "maria@gmail.com");
console.log('' + p);
// Person (name: Maria, email: maria@gmail.com)

let t = new Teacher("Ivan", "iv@yahoo.com", "PHP");
console.log('' + t);
// Teacher (name: Ivan, email: iv@yahoo.com, subject: PHP)

let s = new Student("Ana", "ana@mail.ru", 3);
console.log('' + s);
// Student (name: Ana, email: ana@mail.ru, course: 3)
