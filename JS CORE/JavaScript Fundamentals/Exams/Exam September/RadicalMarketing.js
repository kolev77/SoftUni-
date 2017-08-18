function solve(input) {
    let reg = new Map();
let regex = /[A-Z][A-Za-z]*/;
    for (let i = 0; i < input.length; i++) {
        let match = regex.exec(input[i]);
        if(match){
            input[i].split('-');
            if(input[i].length <= 1){
                reg.set(input[i],new Map());
            }
            else (
                reg.get(input[i]).set()
            )
        }
    }
    console.log(reg)

}



solve(['A','B','C','D','A-B','B-A','C-A','D-A']);