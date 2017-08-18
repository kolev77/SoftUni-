function aggregateTable(lines) {
    let towns = [];
    let incomes = 0;
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
)