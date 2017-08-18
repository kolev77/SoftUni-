class Circle {        // Class CIRCLE will hold property "radius" + accessor properties "diameter" and "area"
    constructor(radius) {
        this.radius = radius;
    }
    get diameter() {
        return 2 * this.radius;
    }

    set diameter(diameter) {
        this.radius = diameter / 2;
    }

    get area() {
        return Math.PI * this.radius * this.radius;
    }
}


let a = new Circle(10);
console.log(a.radius);
console.log(a.diameter);
console.log(a.area);