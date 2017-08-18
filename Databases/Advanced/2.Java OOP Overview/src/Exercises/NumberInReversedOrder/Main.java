package Exercises.NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalNumber number = new DecimalNumber();
        number.setValue(Double.valueOf(br.readLine()));
        System.out.println(number.reverse());
    }
}
