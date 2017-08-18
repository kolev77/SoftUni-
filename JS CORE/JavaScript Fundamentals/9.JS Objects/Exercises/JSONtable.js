function a(input) {
    let html = '<table>\n';
    for (let i = 0; i < input.length; i++) {
        let cuurent = (input[i]).split(',');
        let namesss = cuurent[0].split(':');
        let positionnn = cuurent[1].split(':');
        let salaryyy = cuurent[2].split(':');
        salaryyy[1] = salaryyy[1].substring(0, salaryyy[1].length - 1);

        let name = JSON.parse(namesss[1]);
        let position = JSON.parse(positionnn[1]);
        let salary = JSON.parse(salaryyy[1]);

        html += '    <tr>\n        <td>' + name + '</td>\n' + '        <td>' + position + '</td>\n' + '        <td>' + salary + '</td>\n    <tr>\n'
    }
    html += '</table>';

    console.log(html);
}
a(['{"name":"Pesho","position":"Promenliva","salary":100000}', '{"name":"Teo","position":"Lecturer","salary":1000}', '{"name":"Georgi","position":"Lecturer","salary":1000}']);
//username(["{\"name\":\"Pesho\",\"position\":\"Promenliva\",\"salary\":100000}","{\"name\":\"Teo\",\"position\":\"Lecturer\",\"salary\":1000}","{\"name\":\"Georgi\",\"position\":\"Lecturer\",\"salary\":1000}"]);




function generateJSONTable(data) {
    function htmlEscape(text) {
        text = '' + text;
        let tokensToReplace = {'<': '&lt;', '>': '&gt;', '&': '&amp;', '\'': '&#39;', '"': '&quot;'};
        return text.replace(/[<>&'"]/g, m => tokensToReplace[m]);
    }

    let html = '<table>\n';
    for (let line of data) {
        html += '\t<tr>\n';
        let item = JSON.parse(line);
        for (let key in item) {
            if (item.hasOwnProperty(key)) {
                html += `\t\t<td>${htmlEscape(item[key])}</td>\n`
            }
        }
        html += '\t<tr>\n';
    }

    html += '</table>';

    return html;
}

console.log(generateJSONTable(["{\"name\":\"Pesho\",\"position\":\"Promenliva\",\"salary\":100000}","{\"name\":\"Teo\",\"position\":\"Lecturer\",\"salary\":1000}","{\"name\":\"Georgi\",\"position\":\"Lecturer\",\"salary\":1000}"]));
