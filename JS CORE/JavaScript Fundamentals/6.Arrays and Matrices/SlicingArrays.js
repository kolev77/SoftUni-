let nums = ['one', 'two', 'three', 'four'];
console.log(nums.join('|')); // one|two|three|four

let firstNums = nums.slice(0, 2); // start, end+1
console.log(firstNums.join('|')); // one|two

let lastNums = nums.slice(2, 4); // start, end+1
console.log(lastNums.join('|')); // three|four

let midNums = nums.slice(1, 3); // start, end+1
console.log(midNums.join('|')); // two|three
