package LAB.Exercises.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = br.readLine().split("\\s+");
            Car car = null;
            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            LinkedList<Tire> tires = new LinkedList<>();

            for (int j = 5; j < carData.length - 1; j += 2) {
                double pressure = Double.parseDouble(carData[j]);
                int age = Integer.valueOf(carData[j + 1]);
                Tire tire = new Tire(age, pressure);
                tires.add(tire);
            }

            car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = br.readLine();

        switch (command) {
            case "fragile":
                cars.stream().filter(car -> car.getCargo().getType().equals("fragile"))
                        .filter(car -> car.getTires().stream().filter(tire -> tire.getPressure() < 1)
                                .collect(Collectors.toList()).size() > 0).forEach(x -> System.out.println(x));
                break;
            case "flamable":
                cars.stream().filter(car -> "flamable".equals(car.getCargo().getType()))
                        .filter(car -> car.getEngine().getPower() > 250)
                        .forEach(car -> System.out.println(car));

                break;
        }
    }
}
