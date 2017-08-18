async function loadData() {
    return new Promise(function(resolve, reject) {
        setTimeout(function() { resolve('data'); }, 300);
    });
}
async function loadMoreData(input) {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            resolve(input + ' + more data'); }, 200);
    });
}
async function loadAllData() {
    console.log('Before promise');
    let data = await loadData();
    let moreData = await loadMoreData(data);
    console.log('Result: ' + moreData);
    console.log('After promise');
}

loadAllData();
console.log('Finished');
