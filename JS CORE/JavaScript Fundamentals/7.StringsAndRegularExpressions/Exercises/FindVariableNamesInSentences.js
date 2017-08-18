function findIt([input]) {
    let result = [];
    let pattern = `\\b_([a-zA-Z0-9]+)\\b`; // `\` must be escaped
    let regex = new RegExp(pattern,'g');
    let match = regex.exec(input);
    while (match){
        result.push(match[1]);
        match = regex.exec(input);
    }
    console.log(result.join(','))
}



 findIt(['__invalidVariable _evenMoreInvalidVariable_ _validVariable']);
 findIt(['The _id and _age variables are both integers.']);
 findIt(['Calculate the _area of the _perfectRectangle object.	area,perfectRectangle']);