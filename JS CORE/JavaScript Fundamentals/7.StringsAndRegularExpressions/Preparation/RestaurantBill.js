function getTheBill(input) {
    let purchases = [];
    let bill = 0;
    for (let i = 0; i < input.length; i++) {
        if (i % 2 == 0) {
            purchases.push(input[i]);
        } else {
            bill += Number(input[i]);
        }
    }
    let string = "You purchased ";
    for (let i = 0; i < purchases.length; i++) {
        if (i != purchases.length - 1)
            string += purchases[i] + ','
        else
            string += purchases[i] + ` for a total sum of ${bill}`;
    }
    console.log(string)
}

getTheBill(['Beer Zagorka', '2.65', 'Tripe soup', '7.80', 'Lasagna', '5.69']);

getTheBill(['Cola', '1.35', 'Pancakes', '2.88'])