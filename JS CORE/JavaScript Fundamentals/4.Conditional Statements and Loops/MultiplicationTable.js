function draw(rows) {
    rows = rows.map(Number);
   let html = 'table border="1">\n<tr><th>x</th>';

    for (let i = 1; i <= rows;i++) {
        if (i == rows)
            html += `<th>${i}</th></tr>\n`;
        else
            html += `<th>${i}</th>`;
}
    for(let j = 1; j <= rows; j++){
        html += `<tr><th>${j}</th>`;
        html += `<td>${j}</td>`;
        for(let e = 2; e <= rows; e++){
            let  b = j*e;
            if( j == 1) {
                b == j};
            if (e == rows)
                html += `<td>${b}</td></tr>\n`;
            else
                html += `<td>${b}</td>`
        }
    }
    html+= `</table>`;
    console.log(html);
}

