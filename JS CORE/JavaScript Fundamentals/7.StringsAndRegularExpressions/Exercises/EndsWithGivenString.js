function checkIt([text,target]) {
    if(text.indexOf(target) == text.length-target.length) {
        console.log("true")
    }else
        console.log("false")
}

checkIt(['This sentence ends with fun?','fun?']);