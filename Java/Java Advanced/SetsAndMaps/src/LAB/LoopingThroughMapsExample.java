package LAB;

import java.util.HashMap;

public class LoopingThroughMapsExample {
    public static void main(String[] args) {
        HashMap<String,Integer> vehicles = new HashMap<>();
        vehicles.put("BMW",2);
        vehicles.put("AUDI",3);
        vehicles.put("Mercedes",12);
        vehicles.put("VW",4);

        for (String key: vehicles.keySet()) {
            System.out.println(key + " - " + vehicles.get(key));
        }
    }
}
