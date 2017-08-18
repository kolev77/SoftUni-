function areaAndPerimenter ([a,b]) {
    [a, b] = [a, b].map(Number);
    if (a != Math.round(a) || b != Math.round(b)) {
        console.log((a * b).toFixed(2));
        console.log(((a + b) * 2).toFixed(2));
    }
    else {
        console.log(a * b);
        console.log((a + b) * 2);
    }
}

areaAndPerimenter([2,2])
areaAndPerimenter([1,3])
areaAndPerimenter([2.5,3.14])