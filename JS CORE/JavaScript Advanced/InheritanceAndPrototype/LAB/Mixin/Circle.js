function asCircle() {
    this.area = function() {
        return Math.PI * this.radius * this.radius;
    };
    return this;
}
class Circle {
    constructor(r) { this.radius = r; }
}
asCircle.call(Circle.prototype); // call the function with context which is in the scopes
let circle = new Circle(12);
console.log(circle.area());
