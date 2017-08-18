function createList() {
    let data = [];
    return {
        add: function (item) {
            data.push(item)
        },
        shiftLeft: function () {
            if (data.length > 1) {
                let first = data.shift();
                data.push(first);
            }
        },
        shiftRight: function () {
            if (data.length > 1) {
                let last = data.pop();
                data.unshift(last);
            }
        },
        swap: function (index1, index2) {
            if (!Number.isInteger(index1) || index1 < 0 || index1 >= data.length ||
                !Number.isInteger(index2) || index2 < 0 || index2 >= data.length ||
                index1 === index2) {
                return false;
            }
            let temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
            return true;
        },
        toString: function () {
            return data.join(", ");
        }
    };
}

let expect = require('chai').expect;

    describe('Test cases for testList object functions', function () {

        beforeEach(function () {
            myList = createList();
        });

        describe('Simple Tests', function () {

            it("should return 1,2,3 after {add 1; add 2,add 3}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                let value = myList.toString();
                expect(value).equal('1, 2, 3');
            });



            it("should return 1,gosho,3 after {add 1; add gosho,add 3}", function () {
                myList.add(1);
                myList.add("gosho");
                myList.add(3);
                let value = myList.toString();
                expect(value).equal('1, gosho, 3');
            });

            it("should return 3,1,2, after {add 1; add 2,add 3, shiftLeft}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.shiftLeft();
                let value = myList.toString();
                expect(value).equal('2, 3, 1');
            });

            it("should return 3,1,2, after {add 1; add 2,add 3, shiftLeft}", function () {
                myList.add(1);
                myList.shiftLeft();
                let value = myList.toString();
                expect(value).equal('1');
            });

            it("should return 3,1,2, after {add 1; add 2,add 3, shiftLeft}", function () {
                myList.shiftLeft();
                let value = myList.toString();
                expect(value).equal('');
            });

            it("should return 3,1,2, after {add 1; add 2,add 3, shifRight}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.shiftRight();
                let value = myList.toString();
                expect(value).equal('3, 1, 2');
            });  // true

            it("should return 3,1,2, after {add 1; add 2,add 3,add 4, swap(0,3)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                myList.swap(0,3);
                let value = myList.toString();
                expect(value).equal('4, 2, 3, 1');
            });    // true

            it("should return false after {add 1; add 2,add 3,add 4, swap(0,5)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                let value = myList.swap(1,1);
                expect(value).equal(false);
            });

            it("should return false after {add 1; add 2,add 3,add 4, swap(0,5)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                let value = myList.swap(1,7);
                expect(value).equal(false);
            });

            it("should return false after {add 1; add 2,add 3,add 4, swap(0,5)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                let value = myList.swap(-1,1);
                expect(value).equal(false);
            });

            it("should return false after {add 1; add 2,add 3,add 4, swap(0,5)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                let value = myList.swap(1,-121);
                expect(value).equal(false);
            });

            it("should return false after {add 1; add 2,add 3,add 4, swap(0,5)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                let value = myList.swap("123",1);
                expect(value).equal(false);
            });

            it("should return false after {add 1; add 2,add 3,add 4, swap(0,5)}", function () {
                myList.add(1);
                myList.add(2);
                myList.add(3);
                myList.add(4);
                let value = myList.swap(1,"12312");
                expect(value).equal(false);
            });

        })
})