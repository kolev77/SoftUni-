function check([text,target]) {
    text = text.split(' ');
    if(text[0] == target){
        console.log("true");
    }
    else
        console.log("false")
}

function ch([text,target]) {
    if(text.indexOf(target) == 0) {
        console.log("true")
    }else
        console.log("false")
}

check(['Have you been in Bulgaria ?','Have'])
ch(['Have you been in Bulgaria ?','Have'])
ch(['Marketing Fundamentals, starting 19/10/2016','Marketing Fundamentals, sta'])