let capitals = ['Sofia', 'Washington', 'London', 'Paris'];

capitals.forEach(capital => console.log(capital));

capitals.forEach((capital, i) =>
    console.log(i + ' -> ' + capital));

console.log(capitals.join(', '));

console.log(JSON.stringify(capitals));
