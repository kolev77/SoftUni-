function dnaHelix([num]) {
    let arr = 'ATCGTTAGGG';
    let star = '*';
    let middleSymbol = '-';
    let numberOfStars = 2;
    let rowSymbols = 6;
    let indexOfArr = 0;
    let numberOfDNASymOnRow = 2;
    let starsDecreasing = true; // така ще разбираме дали трябва да увеличаваме или намаляваме звездите;

    for (let i = 0; i < num; i++) {
        let line = star.repeat(numberOfStars);
        line += arr[indexOfArr];
        nextDNAChar();
        line += middleSymbol.repeat(rowSymbols - ((numberOfStars * 2) + numberOfDNASymOnRow));
        line += arr[indexOfArr];
        nextDNAChar();
        line += star.repeat(numberOfStars);
        numberOfStarForNextRow();
        console.log(line);
    }

    function numberOfStarForNextRow() {
        if(starsDecreasing)
        {
            numberOfStars--;
            if(numberOfStars === 0)
            {
                starsDecreasing = false;
            }
        }
        else
        {
            numberOfStars++;
            if(numberOfStars === 2)
            {
                starsDecreasing = true;
            }
        }
    }

    function nextDNAChar() {
        indexOfArr++;
        if(indexOfArr === arr.length)
        {
            indexOfArr = 0;
        }
    }
}
dnaHelix([10])