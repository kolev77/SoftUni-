function count([target,text]) {

    let regex = new RegExp(target, 'g')
    let occurrences = text.match(regex);

    console.log(occurrences.length);
}


count(['the', 'The quick brown fox the jumps over the lay dog.']);

count(['ma', 'Marine mammal training is the training and caring for marine life such as, dolphins, killer whales, sea lions, walruses, and other marine mammals. It is also a duty of the trainer to do mental and physical exercises to keep the animal healthy and happy.'])