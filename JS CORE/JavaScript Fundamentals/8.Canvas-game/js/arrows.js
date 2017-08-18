function draw() {
    window.addEventListener('keydown',animate);

    ctx.fillStyle = 'red';
    let ball = {x:0, y: 700};
    let dirX = true; // for true move right


    function animate(event) {
        if(event.code == "ArrowLeft") { ball.x-=10; }
        else if ( event.code == "ArrowRight") { ball.x+=10;}
        ctx.clearRect(0, 0, 800, 600);
        ctx.beginPath();
        ctx.arc(ball.x, ball.y, 40, 0, Math.PI * 2);
        ctx.fill();
    }
}