let capitals = ['Sofia', 'Washington', 'London', 'Paris'];


for (let capital of capitals)     // fpr. OF - works like foreach
    console.log(capital);

for (let i in capitals)    // for..In goes through array indices
    console.log(i + " " + capitals[i]);


for (let i = 0; i < capitals.length; i++)  // traditional for-loop
    console.log(capitals[i]);

