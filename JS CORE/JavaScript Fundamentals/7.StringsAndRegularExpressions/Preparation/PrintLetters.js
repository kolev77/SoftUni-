function print(input) {
    let msg = input[0];
    for (let i = 0; i < msg.length; i++) {
        console.log(`str[${i}] -> ${msg[i]}`)
    }
}


print(['Hello, World!']);