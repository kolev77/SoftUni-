function multipleValuesForAKey(arr) {
    let dict = {};
    for (let i = 0; i < arr.length - 1; i++) {
        let tokens = arr[i].split(' ');
        let key = tokens[0];
        let value = tokens[1];
        dict[key] = dict[key] || [];
        dict[key].push(value);
    }
    let wanted = arr[arr.length - 1];

    if (dict[wanted] == undefined)
        console.log("None");
    else
        for (let value of dict[wanted])
            console.log(value);
}

multipleValuesForAKey(['key value', 'key eulav', 'test tset', 'key']);
multipleValuesForAKey(['3 bla', '3 alb', '2']);