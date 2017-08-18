function draw() {

    ctx.fillStyle = 'red';
    let ball = {x:0, y: 0};
    let dir = true;
    let live = false;

    window.addEventListener('mousemove',function (event) {
        ball.x = event.clientX;
        ball.y = 560;
        animate();
    });
    function animate() {
        ctx.clearRect(0, 0, 800, 600);
        ctx.beginPath();
        ctx.arc(ball.x, ball.y, 40, 0, Math.PI * 2);
        ctx.fill();
    }
}