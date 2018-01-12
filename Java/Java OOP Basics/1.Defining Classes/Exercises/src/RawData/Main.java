package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        HashMap<Integer, Car> cars = new HashMap<>();
        readCars(br, n, cars);
        String command = br.readLine();

        if (command.equals("fragile")) {
            cars.values().stream().filter(c -> c.getCargo().getType().equals("fragile"))
                    .filter(c -> Arrays.stream(c.getTires()).filter(tire -> {
                        return tire.getPressure() < 1;
                    }).collect(Collectors.toList()).size() > 0)
            .forEach(c -> System.out.println(c.getModel()));
        } else if (command.equals("flamable")) {

            cars.values().stream().filter(c-> c.getCargo().getType().equals("flamable"))
                    .filter(c-> c.getEngine().getPower() > 250)
                    .forEach(c-> System.out.println(c.getModel()));
        }

    }

    private static void readCars(BufferedReader br, int n, HashMap<Integer, Car> cars) throws IOException {
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.valueOf(input[1]);
            int enginePower = Integer.valueOf(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.valueOf(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tire[] tires = new Tire[4];
            int tireCounter = 0;
            for (int j = 5; j < 13; j += 2) {
                Double tirePressure = Double.valueOf(input[j]);
                int tireAges = Integer.valueOf(input[j + 1]);
                Tire tire = new Tire(tireAges, tirePressure);
                tires[tireCounter++] = tire;
            }
            Car car = new Car(model, engine, cargo, tires);
            cars.put(i, car);
        }
    }
}
