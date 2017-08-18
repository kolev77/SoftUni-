function draw(n) {
    n = n.map(Number);

    for (let row = 0; row <= n; row++) {
        console.log("$".repeat(row))
    }
}
draw([3])