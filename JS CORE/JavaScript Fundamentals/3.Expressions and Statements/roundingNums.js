function rounding([x,n]) {
    [x,n] = [x,n].map(Number);
    console.log(x.toFixed(n))
}
rounding([3.1415926535897932384626433832795, 2]);
rounding([10.5, 3]);