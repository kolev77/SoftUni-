package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RoboticsFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsTokens = scanner.nextLine().split(";");
        String[] robots = new String[robotsTokens.length];
        int[] processTimesOfRobot = new int[robotsTokens.length];
        int[] robotsCounter = new int[robotsTokens.length];

        for (int i = 0; i < robotsTokens.length; i++) {
            String[] robotData = robotsTokens[i].split("-");
            robots[i] = robotData[0];
            processTimesOfRobot[i] = Integer.parseInt(robotData[1]);
        }
        String[] time = scanner.nextLine().split(":");
        long h = Integer.parseInt(time[0]) * 60 * 60;
        long m = Integer.parseInt(time[1]) * 60;
        long s = Integer.parseInt(time[2]);
        long seconds = h + m + s;

        ArrayDeque<String> products = new ArrayDeque<>();

        String product = "";
        while (!"End".equals(product = scanner.nextLine())) {
            products.offer(product);
        }

        while (!products.isEmpty()) {
            seconds++;
            for (int robot = 0; robot < robots.length; robot++) { // Checking time of working robots.
                if (robotsCounter[robot] > 0) {
                    robotsCounter[robot]--;
                }
            }

            String currentProduct = products.poll();
            boolean isProductTaken = false;
            for (int robot = 0; robot < robots.length; robot++) {
                if (robotsCounter[robot] == 0) {   // check if there is free robot
                    robotsCounter[robot] = processTimesOfRobot[robot];  // set his processing time
                    isProductTaken = true;  // Check the boolean
                    System.out.printf("%s - %s [%s]\n", robots[robot], currentProduct, convertSecondsToHMmSs(seconds));  // Printing robot`s name and starting time
                    break;
                }
            }
            if (!isProductTaken) {
                products.offer(currentProduct);
            }
        }
    }

    public static String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
