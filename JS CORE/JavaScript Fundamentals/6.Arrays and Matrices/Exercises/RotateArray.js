function rotate(input) {
    let rotations = parseInt(input[input.length-1]);
    input.pop();

    for (let current = 0; current < rotations%input.length; current++) {
     let lastElement = input[input.length-1];
        input.unshift(lastElement);
        input.pop();
    }
    console.log(input.join(" "))
}