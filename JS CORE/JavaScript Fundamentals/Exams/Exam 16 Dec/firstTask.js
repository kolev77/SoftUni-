function solve(input) {
    if(Number(input[0]) >= 26 && Number(input[0]) > 0 && input.constructor == Array) {
        let startingYield = Number(input[0]);
        let workersConsum = 26;
        let days = 0;
        let totalSpiceExtracted = startingYield;
        while (startingYield >= 100) {
            days++;
            totalSpiceExtracted -= workersConsum;
            startingYield -= 10;
            if (startingYield >= 100)
                totalSpiceExtracted += startingYield;
            else
                totalSpiceExtracted -= workersConsum;
        }
        console.log(days);
        console.log(totalSpiceExtracted);
    }else{
        console.log(0);
        //console.log(Number(input[0]));
    }
}
//
solve([111]);
solve([450]);
solve([200]);
solve([0]);