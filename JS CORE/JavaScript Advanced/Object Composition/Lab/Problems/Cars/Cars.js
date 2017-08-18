function cars(input) {
    let cars = new Map();
    let carCreator = (()=>{
        function create(name) {
            cars.set(name, {});
        }
        function createWithInheritance(newCar, parent) {
            cars.set(newCar, Object.create(cars.get(parent)))
        }
        function set(car, key, value) {
            cars.get(car)[key] = value;
        }
        function print(objName) {
            let obj = cars.get(objName);
            let objKeys = Object.keys(cars.get(objName))
                .map(k => `${k}:${cars.get(objName)[k]}`);

            while (obj = Object.getPrototypeOf(obj)) {
                let o = Object.keys(obj).map(k => `${k}:${obj[k]}`);
                objKeys = objKeys.concat(o)
            }
            console.log(objKeys.join(', '));
        }
        return {create, createWithInheritance, set, print}
    })();
    for (let cmd of input){
        cmd = cmd.split(' '); let command = cmd[0];
        if (command == 'create'){
            let name = cmd[1];
            carCreator[command](name);
        }
        if (command == 'create' && cmd.length>3){
            let name = cmd[1];
            let parent = cmd[3];
            command = 'createWithInheritance';
            carCreator[command](name, parent);
        }
        if (command == 'set'){
            let car = cmd[1]; let key = cmd[2]; let value = cmd[3];
            command = 'set';
            carCreator[command](car, key,value);
        }
        if (command == 'print'){
            let car = cmd[1];
            command = 'print'
            carCreator[command](car);
        }
    }
}