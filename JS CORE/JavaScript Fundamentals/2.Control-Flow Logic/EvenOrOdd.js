function check(number) {
    let remainder = number%2;
    if (remainder == 0){
        console.log("even")
    }
    else if (remainder == 1 || remainder == -1 ){
        console.log("odd")
    }
    else{
        console.log("invalid")
    }
}
check("12");
check("55");
check("2");
