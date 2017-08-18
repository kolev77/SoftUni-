function isInside([x,y,xMin,xMax,yMin,yMax]) {
    [x,y,xMin,xMax,yMin,yMax] = [x,y,xMin,xMax,yMin,yMax].map(Number);
    if(x <= xMax && x>=xMin && y<=yMax && y>=yMin)
        console.log("inside")
    else
        console.log("outside")
}