function square([n]) {
    let dash = '-'.repeat(n-2);
    let freeSpace = ' '.repeat(n-2);
    if( n <= 2){
        console.log("+++");
    }
    else if(n%2==0){
        console.log('+' + dash + '+' + dash + '+');
        for (let i = 0; i < ((n-3)/2)-1; i++) {
            console.log('|' + freeSpace + '|' + freeSpace + '|');
        }
        console.log('+' + dash + '+' + dash + '+');
        for (let i = 0; i < ((n-3)/2)-1; i++) {
            console.log('|' + freeSpace + '|' + freeSpace + '|');
        }
        console.log('+' + dash + '+' + dash + '+');

    }
    else {
        console.log('+' + dash + '+' + dash + '+');
        for (let i = 0; i < (n-3)/2; i++) {

            console.log('|' + freeSpace + '|' + freeSpace + '|');
        }
        console.log('+' + dash + '+' + dash + '+');
        for (let i = 0; i < (n-3)/2; i++) {

            console.log('|' + freeSpace + '|' + freeSpace + '|');
        }
        console.log('+' + dash + '+' + dash + '+');
    }
}
square([4])
square([2])