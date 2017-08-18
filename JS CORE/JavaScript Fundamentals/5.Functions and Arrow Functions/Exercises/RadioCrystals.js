function solve(input) {
    input = input.map(Number);
    for (let i = 1; i < input.length; i++) {
        var target = input[0];
        var material = input[i];
        var chunk = material;
        var cuts = 0;
        var laps = 0;
        var grinds = 0;
        var etchs = 0;
        var xrays = 0;
        var washings = 0;

        while (material/4 >= target) {
            material = Cut(material);
        }
        material = transportAndWashing(material);

        while (material-(material*20/100) >= target) {
            material = Lap(material);
        }
        material = transportAndWashing(material);

        while (material - 20 >= target) {
            material = Grind(material);
        }
        material = transportAndWashing(material);

        while (material -2 >= target) {
            material = Etch(material);
        }
        material = transportAndWashing(material);

        while (material-1 >= target) {
            material = Xray(material);
        }
        printOutput(cuts,laps,grinds,etchs,xrays,material,target);
    }


function printOutput(cuts,laps,grinds,etchs,xrays,material,target) {
    console.log(`Processing chunk ${chunk} microns`);
    if (cuts > 0) {
        console.log(`Cut x${cuts}`)
        console.log("Transporting and washing")
    }
    if (laps > 0) {
        console.log(`Lap x${laps}`)
        console.log("Transporting and washing")
    }
    if (grinds > 0){
        console.log(`Grind x${grinds}`)
    console.log("Transporting and washing")
    }if(etchs >0) {
        console.log(`Etch x${etchs}`)
        console.log("Transporting and washing")
    }if(xrays >0) {
        console.log(`X-ray x${xrays}`)
        console.log("Transporting and washing")
    }
    if(material == target)
        console.log(`Finished crystal ${material} microns`)
}

    function Cut(material) {
        material = material/4;
        cuts++;
        return material;
    }
    function Lap(material) {
        material = material- (material*20/100);
        laps++;
        return material;
    }
    function Grind(material) {
        material -= 20;
        grinds++;
    return material;
    }
    function Etch(material) {
        material = material-2;
        etchs++;
        return material;
    }
    function Xray(material) {
        material = material-1;
        xrays++;
        return material;
    }
    function transportAndWashing(material) {
        material = Math.floor(material);
        washings++;
        return material;
    }

}

solve([1375, 50000])
//solve([1000,4000, 8100])