let towns =
    "Sofia, Varna,Pleven,  Veliko Tarnovo;   Paris – London--Viena\n\n Пловдив|Каспичан";

console.log(towns.split(/\W+/)); // incorrect
console.log(towns.split(/\s*[.,|;\n\t-]+\s*/));


// The classical (Perl syntax) is:
//     /<regex>/<options>
//     Examples:
// /[a-z]+/gi      matches all non-empty sequences of Latin letters, case-insensitively
// /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,20}/gi       matches emails (simplified pattern)
