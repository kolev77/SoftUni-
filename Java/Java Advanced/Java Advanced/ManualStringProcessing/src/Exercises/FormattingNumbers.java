package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("\\s+");
        if (numbers.length != 0) {
            int a = Integer.valueOf(numbers[0]);
            double b = Double.valueOf(numbers[1]);
            double c = Double.valueOf(numbers[2]);
            StringBuilder result = new StringBuilder("|");
            result.append(String.format("%-10X", a)).append("|");
            String binaryStringA = Integer.toString(a, 2);
            result.append(String.format("%1$10s", binaryStringA).replace(" ", "0")).append("|");
            result.append(String.format("%1$10.2f", b)).append("|");
            result.append(String.format("%1$-10.3f", c)).append("|");
            System.out.println(result);
        }
    }
}
