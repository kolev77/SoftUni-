package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carArgs = reader.readLine().split("\\s+");
        String[] truckArgs = reader.readLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carArgs[1]), Double.parseDouble(carArgs[2]));
        Truck truck = new Truck(Double.parseDouble(truckArgs[1]), Double.parseDouble(truckArgs[2]));

        int commandCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandCount; i++) {
            String[] commandArgs = reader.readLine().split(" ");
            String command = commandArgs[0];
            String vehicle = commandArgs[1];
            double amount = Double.parseDouble(commandArgs[2]);

            try {
                switch (vehicle.toLowerCase()) {
                    case "car":
                        executeCommand(car, command, amount);
                        break;
                    case "truck":
                        executeCommand(truck, command, amount);
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("Car: %.2f\n",car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n",truck.getFuelQuantity());
    }

    private static void executeCommand(Vehicle vehicle, String command, double amount) {
        DecimalFormat df = new DecimalFormat("#.##");
        switch (command.toLowerCase()) {
            case "drive":
                try {
                    vehicle.drive(amount);
                    System.out.printf("%s travelled %s km\n",vehicle.getClass().getSimpleName(),df.format(amount));
                }catch (IllegalStateException ise){
                    System.out.println(ise.getMessage());
                }
                break;
            case "refuel":
                vehicle.refuel(amount);
                break;
        }
    }
}
