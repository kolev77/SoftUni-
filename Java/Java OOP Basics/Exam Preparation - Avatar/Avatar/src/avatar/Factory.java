package avatar;

import avatar.benders.*;
import avatar.monuments.*;

public final class Factory {
     static void createBender(String type,String name,int power, double secondaryParameter){
        switch (type){
            case "Air":
                Controller.getAirNation().addBender(new AirBender(name,power,secondaryParameter));
                break;
            case "Water":
                Controller.getWaterNation().addBender(new WaterBender(name,power,secondaryParameter));
                break;
            case "Fire":
                Controller.getFireNation().addBender(new FireBender(name,power,secondaryParameter));
                break;
            case "Earth":
                Controller.getEarthNation().addBender(new EarthBender(name,power,secondaryParameter));
                break;
            default:
               break;
        }
    }

     static void createMonument(String type,String name,int affinity){
        switch (type){
            case "Air":
                Controller.getAirNation().addMonument(new AirMonument(name,affinity));
                break;
            case "Water":
                Controller.getWaterNation().addMonument(new WaterMonument(name,affinity));
                break;
            case "Fire":
                Controller.getFireNation().addMonument(new FireMonument(name,affinity));
                break;
            case "Earth":
                Controller.getEarthNation().addMonument(new EarthMonument(name,affinity));
               break;
            default:
                break;
        }
    }


}
