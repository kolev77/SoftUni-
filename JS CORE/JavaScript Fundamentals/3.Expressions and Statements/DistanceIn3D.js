function distance([x,y,z,x1,y1,z1]) {
    [x,y,z,x1,y1,z1] = [x,y,z,x1,y1,z1].map(Number);
    let pointA = {x: x, y: y, z: z};
    let pointB = {x: x1, y: y1, z: z1};

    let distanceX = Math.pow(pointA.x - pointB.x, 2);
    let distanceY = Math.pow(pointA.y - pointB.y, 2);
    let distanceZ = Math.pow(pointA.z - pointB.z, 2);

    return Math.sqrt(distanceX + distanceY +distanceZ);
}

distance([1, 1, 0, 5, 4, 0]);
distance([3.5, 0, 1, 0, 2, -1]);