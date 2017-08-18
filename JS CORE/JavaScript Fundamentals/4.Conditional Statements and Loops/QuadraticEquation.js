function solve([a,b,c]) {
    [a,b,c]= [a,b,c].map(Number);

    let d = Math.pow(b,2) - 4*a*c;
    if( d > 0 ) {
        let x1 = (-b + Math.sqrt(d)) / (2 * a);
        let x2 = (-b - Math.sqrt(d)) / (2 * a);
        console.log(x2);
        console.log(x1);
    }
    if( d == 0 ){
        let x = -b / (2*a);
        return x;
    }
    if( d <0){
        return "No";
    }
}

solve([6,11,-35]);