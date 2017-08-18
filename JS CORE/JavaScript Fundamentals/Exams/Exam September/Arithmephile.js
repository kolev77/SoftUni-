function solve(input) {
    input = input.map(Number);
    let results = [];
    product = -9999999999999;
    for (let i = 0; i < input.length; i++) {
        if(input[i]>= 0 && input[i]<=9) {
            let s = Number(input[i]);
             product = input[i+1];
            let len = i + s;
            if(i+2 <= input.length){
                if(i+s > input.length-1){
                    len = input.length-1-i;
                }
                for (let j = i+1; j < len; j++) {
                    product *= input[j+1];
                }
                results.push(product);
            }
        }
    }
    let largest = Math.max.apply(Math,results);
    console.log(largest)
}

solve(['4','0','15']);
//solve(['10','20','2','30','44','123','3','56','20','24']);
//solve(['100','200','2','3','2','3','2','1','1']);
