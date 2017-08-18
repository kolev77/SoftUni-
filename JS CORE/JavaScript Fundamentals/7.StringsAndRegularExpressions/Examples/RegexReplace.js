let str = '<img src="[imgSource]" />';
str = str.replace(/\[imgSource\]/, './smiley.gif');
console.log(str);

let str1 = 'Visit <link>http://fb.com</link> or <link>http://softuni.bg</link>.';
str1 = str1.replace(/<link>(.*?)<\/link>/g,
    '<a href="$1">Link</a>');
console.log(str1)