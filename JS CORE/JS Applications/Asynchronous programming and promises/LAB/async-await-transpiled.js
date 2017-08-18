let loadData = (() => {
    var _ref = _asyncToGenerator(function* () {
        return new Promise(function (resolve, reject) {
            setTimeout(function () {
                resolve('data');
            }, 300);
        });
    });

    return function loadData() {
        return _ref.apply(this, arguments);
    };
})();

let loadMoreData = (() => {
    var _ref2 = _asyncToGenerator(function* (input) {
        return new Promise(function (resolve, reject) {
            setTimeout(function () {
                resolve(input + ' + more data');
            }, 200);
        });
    });

    return function loadMoreData(_x) {
        return _ref2.apply(this, arguments);
    };
})();

let loadAllData = (() => {
    var _ref3 = _asyncToGenerator(function* () {
        console.log('Before promise');
        let data = yield loadData();
        let moreData = yield loadMoreData(data);
        console.log('Result: ' + moreData);
        console.log('After promise');
    });

    return function loadAllData() {
        return _ref3.apply(this, arguments);
    };
})();

function _asyncToGenerator(fn) { return function () { var gen = fn.apply(this, arguments); return new Promise(function (resolve, reject) { function step(key, arg) { try { var info = gen[key](arg); var value = info.value; } catch (error) { reject(error); return; } if (info.done) { resolve(value); } else { return Promise.resolve(value).then(function (value) { step("next", value); }, function (err) { step("throw", err); }); } } return step("next"); }); }; }

loadAllData();
console.log('Finished');
