package LAB.Exercises.CarSalesMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        HashMap<String, Engine> engines = new HashMap();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            String model = input[0];
            int power = Integer.valueOf(input[1]);
            Engine engine = null;
            switch (input.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    try {
                        int displacement = Integer.parseInt(input[2]);
                        engine = new Engine(model, power, displacement);
                    } catch (NumberFormatException e) {
                        engine = new Engine(model, power, input[2]);
                    }
                    break;
                case 4:
                    engine = new Engine(model, power, input[2], input[3]);
                    break;
            }
            engines.put(model, engine);
        }

        int m = Integer.valueOf(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split("\\s+");
            String model = input[0];
            Engine engine = engines.get(input[1]);
            Car car = null;

            switch (input.length) {
                case 2:
                    car = new Car(model, engine);
                    break;
                case 3:
                    try {
                        int weight = Integer.parseInt(input[2]);
                        car = new Car(model, engine, weight);
                    } catch (NumberFormatException e) {
                        car = new Car(model, engine, input[2]);
                    }
                    break;
                case 4:
                    car = new Car(model, engine, input[2], input[3]);
            }
            cars.add(car);
        }

        cars.forEach(car -> System.out.println(car));
    }
}
