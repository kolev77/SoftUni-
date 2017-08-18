function outer() {
    let inner = () => console.log(this);
    inner();
}
let obj = {
    name: 'Peter',
    f: outer
};
obj.f(); // Object {name: "Peter"}
