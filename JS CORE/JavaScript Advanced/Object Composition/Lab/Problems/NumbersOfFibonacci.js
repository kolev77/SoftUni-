function fibonacci(n) {
    let fib = (() => {
        let f0 = 0, f1 = 1;
        return () => {
            let oldF0 = f0, oldF1 = f1;
            f0 = oldF1;
            f1 = oldF0 + oldF1;
            return oldF1;
        }
    })();

    let result = [];
    for (let i = 1; i <= n; i++){
        result.push(fib());
    }
    console.log(result);
    return result;
}

(fibonacci(15));