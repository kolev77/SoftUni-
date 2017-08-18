function OddNums(n) {
    n = n.map(Number);
    for (let num = 0; num <= n; num++) {
        if( num%2 ==1)
            console.log(num)
    }
}