let nums = [5, 10, 15, 20, 25, 30];
console.log(nums.join('|')); // 5|10|15|20|25|30

let mid = nums.splice(2, 3); // start, delete-count
console.log(mid.join('|')); // 15|20|25
console.log(nums.join('|')); // 5|10|30

nums = [5, 10, 15, 20, 25, 30];
nums.splice(3, 2, "twenty", "twenty-five");
console.log(nums.join('|'));
// 5|10|15|twenty|twenty-five|30
