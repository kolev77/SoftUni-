package NeedForSpeed;

import NeedForSpeed.models.CarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 12-Mar-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();
        String input = br.readLine();

        while (!"Cops Are Here".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "register":
                    int id = Integer.valueOf(tokens[1]);
                    String type = tokens[2];
                    String brand = tokens[3];
                    String model = tokens[4];
                    int yearOfProduction = Integer.valueOf(tokens[5]);
                    int horsepower = Integer.valueOf(tokens[6]);
                    int acceleration = Integer.valueOf(tokens[7]);
                    int suspension = Integer.valueOf(tokens[8]);
                    int durability = Integer.valueOf(tokens[9]);

                    carManager.register(id, type, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                    break;
                case "open":
                    carManager.open(Integer.parseInt(tokens[1]), tokens[2], Integer.valueOf(tokens[3]), tokens[4], Integer.valueOf(tokens[5]));
                    break;
                case "participate":
                    carManager.participate(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
                    break;
                case "check":
                    carManager.check(Integer.valueOf(tokens[1]));
                    break;
                case "start":
                   String a = carManager.start(Integer.valueOf(tokens[1]));
                    System.out.println(a);
                    break;
                case "park":
                    carManager.park(Integer.valueOf(tokens[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.valueOf(tokens[1]));

                    break;
                case "tune":
                    carManager.tune(Integer.valueOf(tokens[1]),tokens[2]);
                    break;
            }
            input = br.readLine();
        }
    }
}
