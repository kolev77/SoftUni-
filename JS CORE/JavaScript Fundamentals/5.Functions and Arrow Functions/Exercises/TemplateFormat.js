function template(input) {

    let xml = `<?xml version="1.0" encoding="UTF-8"?>\n<quiz>\n`

    for( let i = 0; i< input.length; i+=2) {
        let question = input[i];
        let answer = input[i+1];

        let q = `  <question>\n    ${question}\n  </question>\n  <answer>\n    ${answer}\n  </answer>\n`;

        xml += q;

    }
    xml += `</quiz>`
    console.log(xml);
}

template(["Dry ice is a frozen form of which gas?",
    "Carbon Dioxide",
    "What is the brightest star in the night sky?",
    "Sirius"]
)