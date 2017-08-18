function radar([speed,area]) {

    [speed] = [speed].map(Number);
    var limit = getLimit(area);

    function getLimit(area) {
        switch (area) {
            case 'motorway':
                return 130;
            case 'interstate':
                return 90;
            case 'city':
                return 50;
            case 'residential':
                return 20;
        }
    }

    function getInfraction(speed, limit) {
        let overSpeed = speed - limit;
        if (overSpeed <= 0) {
            return false;
        } else {
            if (overSpeed <= 20) {
                return "speeding";
            }
            if (overSpeed <= 40) {
                return "excessive speeding";
            }
            if (overSpeed > 40) {
                return "reckless driving";
            }
        }
    }

    let infraction = getInfraction(speed, limit);
    if (infraction) {
        console.log(infraction)
    }
}

radar([40,'city']);
radar([21,'residential']);
radar([120,'interstate']);
radar([200,'motorway']);