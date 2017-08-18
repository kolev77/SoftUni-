function find() {
    let firstNum = Number(arguments[0]);
    let secondNum = Number(arguments[1]);

    while (firstNum != 0 && secondNum !=0){
        let remainder = secondNum;
        secondNum = firstNum % remainder;
        firstNum = remainder;
    }
    let maxDivider = firstNum+secondNum;
    return maxDivider;
}

find(252,105);