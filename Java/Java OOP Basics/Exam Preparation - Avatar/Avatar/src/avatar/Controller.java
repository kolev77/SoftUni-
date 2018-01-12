package avatar;

import avatar.benders.*;
import avatar.monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private static Nation airNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation fireNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation waterNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation earthNation = new Nation(new ArrayList<>(), new ArrayList<>());


    static void beginWar(){
        Double airPower = airNation.calculateNationPower();
        Double firePower = fireNation.calculateNationPower();
        Double waterPower = waterNation.calculateNationPower();
        Double earthPower = earthNation.calculateNationPower();

        if(airPower > firePower && airPower > waterPower && airPower > earthPower) {
            clearNationBendersAndMonuments(fireNation, waterNation, earthNation);
        } else if(firePower > airPower && firePower > waterPower && firePower > earthPower) {
            clearNationBendersAndMonuments(airNation, waterNation, earthNation);
        } else if(waterPower > firePower && waterPower > airPower && waterPower > earthPower) {
            clearNationBendersAndMonuments(fireNation, airNation, earthNation);
        } else {
            clearNationBendersAndMonuments(fireNation, waterNation, airNation);
        }
    }

    private static void clearNationBendersAndMonuments(Nation n1, Nation n2, Nation n3) {
        n1.clearBenders();
        n1.clearMonuments();
        n2.clearBenders();
        n2.clearMonuments();
        n3.clearBenders();
        n3.clearMonuments();
    }


    public static Nation getAirNation() {
        return airNation;
    }

    public static Nation getFireNation() {
        return fireNation;
    }

    public static Nation getWaterNation() {
        return waterNation;
    }

    public static Nation getEarthNation() {
        return earthNation;
    }

    public static String getStatus(String type) {
        Nation currentNation = getNation(type);
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" Nation\n");
        sb.append("Benders:");
        if (currentNation.getBenders().size() > 0) {
            sb.append("\n");
            for (Bender bender : currentNation.getBenders()) {
                sb.append(bender).append("\n");
            }
        } else {
            sb.append(" None\n");
        }
        sb.append("Monuments:");
        if (currentNation.getMonuments().size() > 0) {
            sb.append("\n");
            for (Monument monument : currentNation.getMonuments()) {
                sb.append(monument).append("\n");
            }
        } else {
            sb.append(" None\n");
        }

        return sb.toString();
    }

    private static Nation getNation(String type) {
        switch (type) {
            case "Air":
                return airNation;
            case "Water":
                return waterNation;
            case "Fire":
                return fireNation;
            case "Earth":
                return earthNation;
            default:
                return null;
        }
    }
}
