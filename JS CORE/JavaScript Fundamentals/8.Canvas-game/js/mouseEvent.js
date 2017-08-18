function draw() {

    ctx.fillStyle = 'red';
    let ball = {x:0, y: 0};
    let dir = true;
    let live = false;

    window.addEventListener('click',function (event) {
        ball.x = 0;
        ball.y = event.clientY;
        if(!live){
            live = true;
            requestAnimationFrame(animate);
        }
        else {
            live = false;
        }
    });
    function animate() {
        ctx.clearRect(0, 0, 800, 600);
        ctx.beginPath();
        ctx.arc(ball.x, ball.y, 40, 0, Math.PI * 2);
        ctx.fill();

        if (dir) {
            ball.x += 5;
            if (ball.x >= 760) {
                dir = false;
            }
        }
        else {
            ball.x -= 5;
            if (ball.x <= 40) {
                dir = true;
            }
        }
        if(live)
        requestAnimationFrame(animate);
    }
}

// if (dirY) {
//     ball.y += 5;
//     if (ball.y >= 570) {
//         dirY = false;
//     }
// }
// else {
//     ball.y -= 5;
//     if (ball.y <= 30) {
//         dirY =
//             true;
//     }
// }