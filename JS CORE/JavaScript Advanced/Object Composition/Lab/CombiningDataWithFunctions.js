let rect = {
    width: 10,
    height: 4,
    grow: function(w, h) {
        rect.width += w; this.height += h;
    },
    print: function() {
        console.log(`[${this.width} x ${this.height}]`);
    }
};
rect.grow(2, 3);
rect.grow(2, 3);
rect.print(); // [12 x 7]
