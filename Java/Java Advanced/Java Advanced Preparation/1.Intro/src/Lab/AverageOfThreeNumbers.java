package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class AverageOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        Double number = Arrays.stream(input).mapToDouble(Double::parseDouble).sum() / input.length;
        System.out.printf("%.2f", number);
    }
}
