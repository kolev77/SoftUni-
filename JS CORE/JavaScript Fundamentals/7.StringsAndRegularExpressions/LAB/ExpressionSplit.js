function expressionSplit(input) {
    let expression = input[0];
    let elements = expression
        .split(/[\s.();,]+/);
    console.log(elements.join("\n"));
}

// /
// [\s.();,]+
// /
// g
// Match a single character present in the list below [\s.();,]+
//     + Quantifier — Matches between one and unlimited times, as many times as possible, giving back as needed (greedy)
// \s matches any whitespace character (equal to [\r\n\t\f\v ])
// .();, matches a single character in the list .();, (case sensitive)
// Global pattern flags
// g modifier: global. All matches (don't return after first match)
//
//
expressionSplit(
    ['let sum = 4 * 4,b = "wow";'])
