function capitalize([string]) {
    let words = string.toLowerCase().split(" ");
    let result = [];
    for(let word of words){
        let firstLetter = word[0].toUpperCase();
        let capitalized = word.replace(word[0],firstLetter);
        result.push(capitalized);
    }
    console.log(result.join(" "));
}

capitalize(["abdi kude si ti aBeeee"])
