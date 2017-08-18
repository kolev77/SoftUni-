function assignProperties([a,valueA,b,valueB,c,valueC]) {
    let obj = {};
    let namePropA = a;
    obj[namePropA] = valueA;

    let namePropB = b;
    obj[namePropB] = valueB;

    let namePropC = c;
    obj[namePropC] = valueC;
    console.log(obj);
    }

assignProperties(['name', 'Pesho', 'age', '23', 'gender', 'male']);

