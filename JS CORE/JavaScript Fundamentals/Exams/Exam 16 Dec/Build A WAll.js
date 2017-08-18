function solve(input) {
    input = input.map(Number);
    let days = 30 - Number(Math.min.apply(null, input));
    let totalConcrete = 0;
    let concretePerDays = [];

    for (let i = 0; i < days; i++) {
        let dailyConcrete = 0;
        for (let j = 0; j < input.length; j++) {
            if (input[j] < 30) {
                input[j]++;
                dailyConcrete += 195;
                totalConcrete += 195;
            }
        }
        concretePerDays.push(dailyConcrete);
    }
    console.log(concretePerDays.join(", "));
    console.log(totalConcrete * 1900 + " pesos")
}


solve(['21', '25', '28']);
solve(['17']);