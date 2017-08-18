function solve([num,n]) {
    [num,n] = [num,n].map(Number);
    if(n > 15) n =15;
    let denominator = Math.pow(10,n);
    let rounded = Math.round(num* denominator) / denominator;

    console.log(rounded);
}

solve([3.1415926535897932384626433832795, 2]);
solve([10.5, 3]);
