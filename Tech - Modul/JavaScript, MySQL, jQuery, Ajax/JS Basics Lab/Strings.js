/**
 * Created by Rostislav on 17.6.2016 г..
 */
let str1 = "Some text in a string variable"
let str2 = 'Text enclosed in single quotes'
for (let i = 0; i < str1.length; i++)
    console.log(str1[i] + ' ' + str2[i])


let tokens = 'C#, Java, PHP ,HTML'.split(',');
// tokens = ['C#', ' Java', ' PHP ', 'HTML']
tokens = tokens.map(s => s.trim());
console.log(tokens);
// ['C#', 'Java', 'PHP', 'HTML']
