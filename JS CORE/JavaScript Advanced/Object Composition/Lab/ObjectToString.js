let rect = {
    width: 10,
    height: 4,
    toString: function() {
        return `rect[${this.width} x ${this.height}]`;
    }
};


console.log(rect); // Object {width: 10, height: 4}
// This will invoke toString() to convert the object to String
console.log(rect.toString());


console.log('' + rect); // rect[12 x 7]

let rect2 = {
    width: 10,
    height: 4,
    toString: function() {
        return `rect[${this.width} x ${this.height}]`;
    }
};

console.log([rect,rect2].join(', '));