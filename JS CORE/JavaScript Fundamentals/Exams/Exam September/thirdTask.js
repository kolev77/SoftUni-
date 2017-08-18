function solve(input) {
    let specKey = input.shift(input[0]);
    let text = input.join('\n')

    function change(text) {
        let map = {'!': '1', '%': '2', "3": '#', '4': '$'};
        return text.replace(/[^a-zA-Z0-9]/g,'_', ch => map[ch]);
    }
    let a = change(text);

    console.log(a)

}

solve(['enCode','Some messages are just not encoded what can you do?','RE - ENCODE THEMNOW! - he said.','Damn encode, ITSALLHETHINKSABOUT, eNcoDe BULL$#!%.']);