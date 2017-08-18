function draw() {
    let ctx = document.getElementById('canvas').getContext('2d');

    ctx.fillStyle = 'red';
    let ball = {x:0, y: 0};

    let dirX = true; // for true move right
    let dirY = true;  // for true move down

    function animate() {
        ctx.clearRect(0, 0, 800, 600);
        ctx.beginPath();
        ctx.arc(ball.x, ball.y, 40, 0, Math.PI * 2);
        ctx.fill();

        if (dirX) {
            ball.x += 5;
            if (ball.x >= 760) {
                dirX = false;
            }
        }
        else {
            ball.x -= 5;
            if (ball.x <= 40) {
                dirX = true;
            }
        }
            if (dirY) {
                ball.y += 5;
                if (ball.y >= 570) {
                    dirY = false;
                }
            }
            else {
                ball.y -= 5;
                if (ball.y <= 30) {
                    dirY =
                    true;
                }
            }
            requestAnimationFrame(animate);
        }
        animate();

}

