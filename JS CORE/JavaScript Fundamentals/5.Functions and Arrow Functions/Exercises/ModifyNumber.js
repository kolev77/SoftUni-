function modify(num) {
    let digits = [];
    let sNumber = num.toString();
    let average = null;

    for (let i = 0; i < sNumber.length; i++) {
        digits.push(sNumber.charAt(i));
    }
    digits = digits.map(Number);
    while (average <= 5){
        digits.push(9);
        average = 0;
        for (let i = 0; i < digits.length; i++) {
            let digit = parseInt(digits[i]);
            average += digit;
        }
        average = average/digits.length;
    }
    console.log(digits.join(""));
}

modify([101]);
modify([5835]);