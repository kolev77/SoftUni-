package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();

        readCars(reader, cars);
        driveCars(reader, cars);
        cars.values().forEach(System.out::println);

    }

    private static void driveCars(BufferedReader reader, Map<String, Car> cars) throws IOException {
        String driveCars;
        while (!"End".equals(driveCars = reader.readLine())) {
            String[] input = driveCars.split(" ");
            String model = input[1];
            int distance = Integer.parseInt(input[2]);
            cars.get(model).drive(distance);
        }
    }

    private static void readCars(BufferedReader reader, Map<String, Car> cars) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] carInput = reader.readLine().split(" ");
            cars.put(carInput[0],new Car(carInput[0],Double.valueOf(carInput[1]),Double.valueOf(carInput[2])));
        }
    }
}
