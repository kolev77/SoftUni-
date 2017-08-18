function negativePositiveNumbers(arr) {
    arr = arr.map(Number);
    let result = [];
    for (num of arr)
        if (num < 0)
            result.unshift(num); // Insert at the start
        else
            result.push(num); // Append at the end
    console.log(result.join('\n'));
}

negativePositiveNumbers([3,-5,0,-1])
