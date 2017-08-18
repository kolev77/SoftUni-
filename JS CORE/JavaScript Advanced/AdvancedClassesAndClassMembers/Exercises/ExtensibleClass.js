let Extensible = (function () {
    let uniqueId = 0;

    return class Extensible {
        constructor() {
            this.id = uniqueId++;
        }

        extend(otherObject) {
            for (let prop in otherObject) {
                if (otherObject.hasOwnProperty(prop)) {
                    if (typeof otherObject[prop] == 'function') {
                        Extensible.prototype[prop] = otherObject[prop];
                    } else {
                        this[prop] = otherObject[prop];
                    }
                }
            }
        }
    }
})();

let obj1 = new Extensible();
let obj2 = new Extensible();
let obj3 = new Extensible();
obj1.extend(obj2);
console.log(obj1.id);
console.log(obj2.id);
console.log(obj3.id);

