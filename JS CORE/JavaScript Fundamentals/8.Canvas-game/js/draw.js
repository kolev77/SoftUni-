function draw() {
    let canvas = document.getElementById("canvas");

    ctx.fillStyle= 'blue';
    ctx.fillRect(100,100,410,25);
    ctx.fillStyle= 'white';
    ctx.fillRect(105,105,400,15);
    ctx.fillStyle= 'blue';

    let timer = setInterval(bit,500);
    let progress = 0;
    bit();
    function bit() {
        ctx.fillRect(107 + progress*40,107,36,11);
        progress++;
        if(progress == 10 ) clearInterval(timer);
    }

}