package LAB.Problems;

import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> parking = new HashSet<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] command = input.split(", ");
            if (command[0].equals("IN")) {
                parking.add(command[1]);
            } else if (command[0].equals("OUT")) {
                parking.remove(command[1]);
            }
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }
    }
}
