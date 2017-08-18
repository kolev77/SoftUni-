//Before ES2015 (ES6), classes were composed manually

function RectangleLegacy(width, height) {
    this.width = width;    // Constructor function defines class data
    this.height = height;
}
RectangleLegacy.prototype.area = function () {
    return this.width * this.height;    // Behavior (methods) is later attached to the prototype
}
let rect = new RectangleLegacy(3, 5);  //  Instantiation works the same way

console.log(rect.area());




class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }



    area() {
        return this.width * this.height;
    }

}

let b = new Rectangle(5,4);
console.log(b.area());