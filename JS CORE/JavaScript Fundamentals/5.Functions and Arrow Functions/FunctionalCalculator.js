function calculate([a,b,op]) {
    [a,b] = [a,b].map(Number);
    if(op == '+')
        return a+b;
    if(op == '-')
        return a-b;
    if(op == '/')
        return a/b;
    if(op == '*')
        return a*b;
}

console.log(calculate(['2', '4', '+']));
console.log(calculate(['3', '3', '/']));
console.log(calculate(['18', '-1', '*']));