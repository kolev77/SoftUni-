function solve(text) {

 let result = [];
 for (let i = 0; i < text.length-1; i++) {
  let key = text[i].split(' ')[0];
  let value = text[i].split(' ')[1];
  result[key] = value;
 }
 let targetKey = text[text.length-1];
 if( result[targetKey] == undefined)
 {console.log("None")}
 else {
  console.log(result[targetKey])
 }
}

solve(['1 rqpa', '2 dupe', '2 cici', '3 potakis', '2', '3']);