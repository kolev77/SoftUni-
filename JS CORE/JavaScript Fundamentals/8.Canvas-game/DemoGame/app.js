function init() {
    let hoomerImg =  document.getElementById('player');
    let beerOne = document.getElementById('beerOne');

    draw();

    function draw() {
        let ctx = document.getElementById('canvas').getContext('2d');
        ctx.drawImage(beerOne,0,0);
        ctx.drawImage(hoomerImg,0,0);
    }
}
init();
