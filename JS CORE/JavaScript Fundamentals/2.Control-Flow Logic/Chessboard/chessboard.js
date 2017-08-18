function chessboard([n]) {
    let html = '<div class="chessboard">\n';
    for (let row = 1; row <= n; row++) {
        let color = ( row % 2 == 0) ? "white" : "black";
        html += "  <div>\n";
        html += "    ";
        for (let col = 1; col <= n; col++) {
            html += `<span class="${color}"></span>`;
            color = (color == "white") ? "black" : "white";
        }
        html += "\n  </div>\n";

    }
    html += "</div>\n";
    return html;
}
console.log(chessboard([4]));