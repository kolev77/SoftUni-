function solve(input) {
    let cars = new Map();

    for (let line of input) {
        let tokens = line.split(" ");
        switch (tokens[0]){
            case 'create':
                if(tokens.length == 2) {
                    create(tokens[1]);  // value of the car
                } else {
                    inherit(tokens[1],tokens[3]);
                }
                break;
            case 'set':
                set(tokens[1],tokens[2],tokens[3])
                break;
            case 'print':
                print(tokens[1])
                break;
        }
    }
    function create(name) {
        let car = {};
        cars.set(name,car); // key = name; value = car;
    }

    function inherit(name,parent) {
        let car = Object.create(cars.get(parent));
        cars.set(name,car); // key = name; value = car;
    }
    function set(name,key,value) {
        let car = cars.get(name); // get the car from cars map
        car[key] = value;
    }
    function print(name) {
        let car = cars.get(name); // get the car from cars map
        let props = [];
        for (let prop in car) {
            props.push(`${prop}:${car[prop]}`)  // {1} - name of prop, {2} - value
        }
        console.log(props.join(', '))
    }
}

solve(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']);