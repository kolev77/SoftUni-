function thirdWay(input) {
    let text = input.join('\n').toLowerCase();
    let regex = /[^A-Za-z0-9-]+/;  // започва със буква число или долна черта много пъти
    let words = text.split(regex).filter(w => w != ''); // премахни празните членове
    let wordsCount = new Map();

    for (let something of words) {
        if (wordsCount.has(something)) {
            wordsCount.set(something, wordsCount.get(something) + 1)
        }
        else {
            wordsCount.set(something, 1)
        }
    }
    let allwords = Array.from(wordsCount.keys()).sort();
    allwords.forEach(w=>console.log("\'" + w + "\'" + " -> " + wordsCount.get(w) + ' times'))

}
thirdWay((['JS and Node.js', 'JS again and again', 'Oh, JS?']));
thirdWay((['JS and Node.js', 'JS again and again', 'Oh, JS?']));