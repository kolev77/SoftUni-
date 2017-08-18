function capture(input) {
    let numbers = [];
    let regex = /\d+/g;
    let text = "";

    for (let i = 0; i < input.length; i++) {
        let currentSentence = input[i];
        text += currentSentence;
    }
    let match = regex.exec(text);

    while (match){
        numbers.push(match[0]);
        match = regex.exec(text);
    }
    console.log(numbers.join(' '))
}


function captureSimple(input) {
    let text = input.join(' ');
    let regex = /\d+/g;
    let numbers = text.match(regex);
    console.log(numbers.join(' '));


}
captureSimple(['123a456',
        '789b987',
        '654c321',
        '0'])