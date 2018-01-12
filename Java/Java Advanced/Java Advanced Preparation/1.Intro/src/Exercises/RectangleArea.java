package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) throws IOException {
        Scanner scanner  = new Scanner(System.in);
        double b = scanner.nextDouble();
        double a = scanner.nextDouble();

        System.out.printf("%.2f",a*b);
    }
}
