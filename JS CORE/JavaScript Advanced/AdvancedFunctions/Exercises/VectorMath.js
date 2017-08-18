let a = (function () {
    return {
        add: (a, b) => {
            let result = [];
            result[0] = Number(a[0]) + Number(b[0]);
            result[1] = Number(a[1]) + Number(b[1]);
            return result
        },
        multiply: (arr, multiplier)=> {
            let result = [];
            result[0] = Number(arr[0]) * Number(multiplier);
            result[1] = Number(arr[1]) * Number(multiplier);
            return result;
        },
        length: (arr) => {
            let result = Math.sqrt(Math.pow(arr[0], 2) + Math.pow(arr[1], 2));
            return result;
        },
        dot: (a, b) => {
            let result = a[0] * b[0] + a[1] * b[1];
            return result;
        },
        cross: (a, b)=> {
            let arr = a[0] * b[1] - a[1] * b[0];
            return arr;
        }
    };
})();

console.log(a.add([1, 1], [1, 0]));