package ProblemsLAB;

import java.util.Scanner;

/**
 * Created by Rostislav Kolev on 16-Jan-17.
 */
public class AverageThreeNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        double third = sc.nextDouble();
        double sumAbs = first + second + third;
        double avg = sumAbs / 3;
        System.out.printf("%.3f", avg);
        System.out.printf("%.2f", avg);
        System.out.printf("%.4f", avg);
    }
}
