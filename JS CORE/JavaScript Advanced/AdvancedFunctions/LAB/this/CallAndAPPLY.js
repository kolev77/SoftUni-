let maria = {
    name: "Maria",
    hello: function(thing) {
        console.log(this.name + " says hello " + thing);
    }
}
maria.hello("world"); // Maria says hello world

let ivan = { name: 'Ivan' };
maria.hello.call(ivan, "now"); // Ivan says hello now
maria.hello.apply(ivan, ["again",'abdi']); // Ivan says hello again
