class Rat {
    constructor(name){
        this.name = name;
        this.rats = [];
    }
    unite(otherRat) {
        if(otherRat instanceof Rat){   //function should only add the object if it is an object of the class Rat.
            this.rats.push(otherRat)   // In any other case it should do nothing.
        }
    }
    getRats(){
        return this.rats;
    }
    toString() {
        let output = '';
        output += this.name + '\n';
        for (let rat of this.rats) {
            output += `##${rat}\n`;
        }
        return output.trim();
    }
}