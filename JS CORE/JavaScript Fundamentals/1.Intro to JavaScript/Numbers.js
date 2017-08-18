let n = 5;
console.log(typeof(n) + ' ' + n); // number 5
let bin = 0b10000001;
console.log(typeof(bin) + ' ' + bin); // number 129
let x = Number.parseInt("2.99");
console.log(typeof(x) + ' ' + x); // number 2
let y = Number("2.99");
console.log(typeof(y) + ' ' + y); // number 2.99

        let a = 3, b = 4 / a;
        console.log(`a=${a} b=${b}`); // a=3 b=1.3333333333333333
        console.log(a / 0); // Infinity
        console.log(a * Infinity); // Infinity
        console.log(0 / 0); // NaN
        let bigNum = 10000000000000000;
        console.log(bigNum + 1); // 10000000000000000
        let num = 0.01, sum = 0;
        for (let i=0; i<100; i++)
            sum += num;
        console.log(sum);
