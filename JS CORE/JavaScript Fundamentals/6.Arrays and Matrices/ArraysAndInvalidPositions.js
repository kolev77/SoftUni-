let nums = [10, 20, 30];
nums[4] = 50; // Will resize the array
console.log(nums); // [10, 20, 30, ,50]
console.log(nums.length); // 5
console.log(nums[3]); // undefined

console.log(nums[-5]); // undefined
nums[-5] = -5; // Will not resize the array (invalid index)!
console.log([nums[-5], nums.length]); // [-5, 5]

console.log(nums[100]); // undefined
nums[100] = 100; // Will resize the array
console.log([nums[100], nums.length]); // [100, 101]
