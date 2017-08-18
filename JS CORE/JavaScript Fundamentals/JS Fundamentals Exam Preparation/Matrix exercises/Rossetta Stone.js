function solve(input) {
    let n = Number(input[0]); // length of the template matrix
    let template = [];
    let secretMessage = [];

    //Template
    for (let i = 1; i <= n; i++) {
        let line = input[i].split(' ').map(Number);
        template.push(line);
    }

    //Secret message
    for (let a = n+1; a < input.length; a++) {
        let line = input[a].split(' ').map(Number);
        secretMessage.push(line);
    }


    let templateRows = n;
    let templateCols = template[0].length;
    let secretMessRows = secretMessage.length;
    let secretMessCols = secretMessage[0].length;

    let code = [' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
    for (let row = 0; row < secretMessRows; row++) {
        for (let col = 0; col < secretMessCols; col++) {
            secretMessage[row][col] += template[row%templateRows][col%templateCols];
            let num = secretMessage[row][col];
            let letterIndex = num%27;

            secretMessage[row][col] = code[letterIndex];
        }
    }
    console.log(secretMessage.map(row=>row.join(''))
        .join(''));
}


solve([
    '2',

    //  0  1
    '59 36',  // 0
    '82 52',  // 1

    // 0  1  2  3  4
    '4 18 25 19 8',     //0
    '4 2 8 2 18',       //1
    '23 14 22 0 22',    //2
    '2 17 13 19 20',    //3
    '0 9 0 22 22' ]);   //4

// print matrix
// console.log(template.map(row=>row.join(' '))
//     .join('\n'));