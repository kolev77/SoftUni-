function a(input) {

    let string = '<ul>\n';

    for (let i = 0; i < input.length; i++) {
        let replaced = input[i];

        replaced = replaced.split('&').join('&amp;');
        replaced = replaced.split('<').join('&lt;');
        replaced = replaced.split('>').join('&gt;');
        replaced = replaced.split('"').join('&quot;');

        string += '  \<li>' + replaced + '</li>\n';

        let a1 = "&lt;"
    }
    string += '</ul>';

    console.log(string);

}
a(['<b>unescaped text</b>', 'normal text']);
a(['<div style=\"color: red;\">Hello, Red!</div>', '<table><tr><td>Cell 1</td><td>Cell 2</td><tr>']);


// function htmlList(items) {
//     return "<ul>\n" +
//         items.map(htmlEscape).map(
//             item => `  <li>${item}</li>`).join("\n") +
//         "</ul>\n";
//     function htmlEscape(text) {
//         let map = { '"': '&quot;', '&': '&amp;',
//             "'": '&#39;', '<': '&lt;', '>': '&gt;' };
//         return text.replace(/[\"&'<>]/g, ch => map[ch]);
//     }
// }
// document.write(htmlList(["<br>", "It's OK"]))
//
