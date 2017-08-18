function myfunc1(val) {
    return val + 1;
}

let myfunc2 = function (val) {
    return val + 1;
}

let myfunc3 = new Function("val","return val + 1");