function solve(input) {

    let string = input[0].toLowerCase();        // case insensitive
    let searchedWord = input[1].toLowerCase();  // case insensitive

    let inside = `\\b${searchedWord}\\b`;
    let regex = string.match(new RegExp(inside, 'g'));

    console.log(regex?regex.length:0);
}
//solve(['The waterfall was so high, that the child couldn’t see its peak.', 'the']);
//solve(['Marine mammal training is the training and caring for marine life such as, dolphins, killer whales, sea lions, walruses, and other marine mammals. It is also a duty of the trainer to do mental and physical exercises to keep the animal healthy and happy.', 'ma']);
solve(['There was one. Therefore I bought it. I wouldn`t buy it otherwise.', 'there']);
solve(['There was one. Therefore I bought it. I wouldn`t buy it otherwise.', '0']);