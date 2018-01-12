package Exercises;

import java.util.Scanner;

/**
 * Created by Rostislav Kolev on 17-Jan-17.
 */
public class RectangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();

        System.out.printf("%.2f",a*b);
    }
}
