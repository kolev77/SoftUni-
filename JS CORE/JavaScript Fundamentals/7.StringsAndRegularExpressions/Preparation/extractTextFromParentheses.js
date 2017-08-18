function extract([text]) {
  let pattern = '\\((.*?)\\)';
  let regex = new RegExp(pattern,'g');

    let match = regex.exec(text);
    let result = [];
    while(match){
        result.push(match[1]);
        match = regex.exec(text);
    }
    console.log(result.join(", "))
}
extract(['Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)'])