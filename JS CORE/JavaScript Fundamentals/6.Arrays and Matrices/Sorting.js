let nums = [20, 40, 10, 30, 100, 5];
console.log(nums.join('|')); // 20|40|10|30|100|5

nums.sort(); // Works incorrectly on arrays of numbers !!!
console.log(nums.join('|')); // 10|100|20|30|40|5

nums.sort((a, b) => a-b); // Compare elements as numbers
console.log(nums.join('|')); // 5|10|20|30|40|100

