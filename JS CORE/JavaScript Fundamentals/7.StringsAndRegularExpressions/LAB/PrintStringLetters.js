function print(str) {
    if (Array.isArray(str))
        str = str[0]; // Take the first element
    for (let i in str)
        console.log(
            `str[${i}] -> ${str[i]}`);

}

print('Hello');
print(['SoftUni']);
