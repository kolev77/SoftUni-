function tripLength([x1,y1,x2,y2,x3,y3]) {
    [x1, y1, x2, y2, x3, y3] = [x1, y1, x2, y2, x3, y3].map(Number);

    let distance = function (x1, y1, x2, y2){ return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))}

    let AtoB = distance(x1,y1,x2,y2);
    let AtoC = distance(x1,y1,x3,y3);
    let BtoC = distance(x2,y2,x3,y3);

    if( AtoB + BtoC <= AtoC+BtoC)
        console.log("1->2->3: "+(AtoB+BtoC));
   else if( AtoB + AtoC < BtoC+AtoC)
        console.log("2->1->3: "+(AtoB+AtoC))
    else
        console.log("1->3->2: "+(AtoC+BtoC));
}

// tripLength([0, 0, 2, 0, 4, 0]);
 tripLength([5, 1, 1, 1, 5, 4]);
// tripLength([0,3,1,0,-1,0])
// tripLength([-1, -2, 3.5, 0, 0, 2])