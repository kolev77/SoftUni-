function distanceOverTime([v1,v2,t]) {
    [v1,v2,t] = [v1,v2,t].map(Number);
    v1 = v1*1000/3600;
    v2 = v2*1000/3600;
    let s1 = v1*t;
    let s2 = v2*t;
    let delta = Math.abs(s1-s2);
    console.log(delta);
}
distanceOverTime([0, 60, 3600]);
distanceOverTime([11, 10, 120]);
distanceOverTime([5, -5, 40]);