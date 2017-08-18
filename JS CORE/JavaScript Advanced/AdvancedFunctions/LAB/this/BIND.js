/**
 * Created by Rostislav Kolev on 24-Oct-16.
 */
let maria = {
    name: "Maria",
    hello: function(thing) {
        console.log(this.name + " says hello " + thing);
    }
}
let ivan = { name: 'Ivan' };
let helloIvan = maria.hello.bind(ivan);
maria.hello("world"); // Maria says hello world
helloIvan("from me"); // Ivan says hello from me
