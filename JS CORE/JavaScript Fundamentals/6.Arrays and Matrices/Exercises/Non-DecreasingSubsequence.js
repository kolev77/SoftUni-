function extract(input) {
   input = input.map(Number);
    let result = [input[0]];
    let lastBiggestN = result[0];
    for (let i = 0; i < input.length; i++) {
        if(lastBiggestN < input[i])
            lastBiggestN = input[i];
              if(lastBiggestN < input[i+1]){
                  result.push(input[i+1])
              }
    }
    console.log(result.join('\n'));
}

extract(['1','3','8','4','10','12','3','2','24']);

//extract(['1','2','3','4']);
//extract(['20','3','2','15','6','1']);

function extractSubsequence(arr) {
    arr = arr.map(Number);

    let result = arr.filter((x, i) => x >= Math.max(...arr.slice(0, i + 1))).join('\n');

    console.log(result);
}

function a(input) {
    input = input.map(Number);
    let arr = [];
    let biggest;
    input.forEach(function(e){
        if (biggest != undefined){
            if (e >= biggest){
                arr.push(e);
                biggest = e;
            }
        }
        else{
            biggest = e;
            arr.push(e);
        }
    });
    arr.forEach(e => console.log(e));
}