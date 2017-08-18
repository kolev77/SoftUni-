let nums = [10, 20, 30];
console.log(nums.join('|')); // 10|20|30

nums.push(40);
console.log(nums.join('|')); // 10|20|30|40

let tail = nums.pop();       // tail = 40 (cut 40 from the array)
console.log(nums.join('|')); // 10|20|30

nums.unshift(0);
console.log(nums.join('|')); // 0|10|20|30

let head = nums.shift();     // head = 0
console.log(nums.join('|')); // 10|20|30
