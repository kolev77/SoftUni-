function aggregateTable(lines) {
    let towns = [];
    let incomes = 0;
    let names = lines.map((l) => l.split('|').join(" ").match(/([a-zA-Z])*/g).filter((x) => x !== "" ));
    names.join(" ");
    console.lo
    for (let i = 0; i < names.length; i++) {
        let name = names[i].join(" ");
        console.log(name)
    }


    // console.log(names)



    for(let line of lines)
    {
        let townsData = line.split('|');
        let town = townsData[1].trim();
        let income = parseInt(townsData[2].trim());
        towns.push(town);
        incomes+=income;
    }
    console.log(towns.join(','));
    console.log(incomes);
}

aggregateTable(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275']
);


// SHORTLY WAY
//
// function printBill(input) {
//     let items = input.filter((x,i) => i%2==0);
//     let sum = input.filter((x,i) => i%2==1)
//         .map(Number)
//         .reduce((a,b) => a + b);
//     console.log(`You purchased ${items.join(', ')} for a total sum of ${sum}`);
// }
