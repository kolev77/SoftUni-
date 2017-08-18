function print(input) {
    let delimiter = input[input.length-1];
    input.pop();
    console.log(input.join(delimiter));
}

print(['One', 'Two', 'Three', 'Four', 'Five', '-']);