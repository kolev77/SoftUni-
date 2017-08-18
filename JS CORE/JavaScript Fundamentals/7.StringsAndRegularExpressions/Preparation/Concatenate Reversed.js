function concatenate(input) {
    let result = [];
    for (let msg of input) {
        result.push(msg);
    }
    console.log(result.reverse().join(""))
}

concatenate(['I', 'am', 'student'])
concatenate(['car', 'race']);