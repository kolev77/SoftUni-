function solve(input) {
    let airPlanes = [];

    for (let rows = 0; rows < input.length; rows++) {
        let planeDescription = input[rows].split(' ');
        let plane_id = planeDescription[0];
        let plane_destination = planeDescription[1];
        let passengers = Number(planeDescription[2]);
        let planeAction = planeDescription[3];

        if (planeAction == 'land') {
            let plane = {
                id: plane_id,
                passengers: passengers,
                arrivals: passengers,
                destination: plane_destination,
                land: true
            };
            airPlanes.push(plane);
        }
        if (planeAction == "depart") {
            for (let i = 0; i < airPlanes.length; i++) {
                if (airPlanes[i].id == plane_id)
                    airPlanes[i].depart = true;
            }
        }
    }
    let planes_left = [];

    for (let plane of airPlanes) {
        if (plane.depart == null && plane.land === true) {
            planes_left.push(plane.id);
        }
    }
    console.log("Planes left:\n- " +planes_left.sort().join("\n- "))


    let airPortsInfoArrive = [];
    for (let i = 0; i < airPlanes.length; i++) {
        let airPortName = airPlanes[i].destination;

        let destination = {
            name: airPortName,
            passengers: airPlanes[i].passengers,
            planes: airPlanes[i].id,
            completeInfo: null
        }

        for (let info of airPortsInfoArrive) {
                if(info.name === destination.name){
                    destination.passengers += info.passengers;
                    destination.planes += ", " + info.planes;
                    destination.completeInfo = true;
                }
            }
    airPortsInfoArrive.push(destination);
        if(destination.completeInfo){

            console.log(destination.name+'\n'+`Arrivals: ${destination.passengers}`);
        }
    }

}

// solve([
//     "Boeing474 Madrid 300 land",
//     "AirForceOne WashingtonDC 178 land",
//     "Airbus London 265 depart",
//     "ATR72 WashingtonDC 272 land",
//     "ATR72 Madrid 135 depart"
// ]);


solve([
    "Airbus Paris 356 land",
    "Airbus London 321 land",
    "Airbus Paris 213 depart",
    "Airbus Ljubljana 250 land"
])