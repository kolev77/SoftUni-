package LAB.Exercises.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            String model = input[0];
            Double fuelAmount = Double.valueOf(input[1]);
            Double costPerKm = Double.valueOf(input[2]);
            Car currentCar = new Car(model, fuelAmount, costPerKm);
            cars.put(model, currentCar);
        }

        String command = br.readLine();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            Integer distance = Integer.valueOf(tokens[2]);
            cars.get(model).drive(distance);
            command = br.readLine();
        }

        cars.values()
                .stream()
                .forEach(car -> System.out.println(car));
    }
}
