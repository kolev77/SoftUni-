let sum = require("../sum-array").sum;
let expect = require("chai").expect;

describe("Test sum(arr)", function () {
    it("should return 3 for [1,2]", function () {
        let expectedSum = 3;
        let actualSum = sum([1, 2]);
        expect(actualSum).equal(expectedSum);
    });

    it("should return 5 for [5]", function () {
        let expectedSum = 5;
        let actualSum = sum([5]);
        expect(actualSum).equal(expectedSum);
    });

    it("should return 0 for []",function () {
        let expectedSum = 0;
        let actualSum = sum([]);
        expect(actualSum).equal(expectedSum);
    });
});

console.log(sum([1, 2]));
console.log(sum([5]));