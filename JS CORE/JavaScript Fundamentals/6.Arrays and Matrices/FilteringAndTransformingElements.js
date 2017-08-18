let nums = ['one', 'two', 'three', 'four'];
console.log(nums.join('|')); // one|two|three|four

let filteredNums =
    nums.filter(x => x.startsWith('t'));
console.log(filteredNums.join('|')); // two|three

let lengths = nums.map(x => x.length);
console.log(lengths.join('|')); // 3|3|5|4

let lengths = nums.map(x => [x.length, x[0]]);
console.log(lengths.join('|')); // 3,o|3,t|5,t|4,f
