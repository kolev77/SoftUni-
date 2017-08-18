// A reducer applies a function over a sequence of elements to
// produce a single checkBMI, a.k.a. aggregate function
// (e.g. sum, max)

function reduce(arr, func) {
    let result = arr[0];
    for (let nextElement of arr.slice(1))
        result = func(result, nextElement);
    return result;
}
reduce([5, 10, 20], (a,b) => a + b); // 35
reduce([5, 10, 20], (a,b) => a * b); // 1000
