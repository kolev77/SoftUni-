function oddNums(arr) {
    let result = arr
        .filter((num, i) => i % 2 == 1)
        .map(x => 2*x)
        .reverse();
    return result.join(' ');
}

console.log(oddNums([10,15,20,25]));
console.log(oddNums([3,0,10,4,7,3]));
