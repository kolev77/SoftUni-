package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.*;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(x -> Integer.valueOf(x)).toArray();

        BiFunction<String, Integer, Integer> someFunction = (x, y) -> {
            switch (x) {
                case "add":
                    return y + 1;
                case "multiply":
                    return y * 2;
                case "subtract":
                    return y - 1;
                default:
                    return null;
            }
        };

        Consumer<int[]> printThem = x -> {
            StringBuilder sb = new StringBuilder();
            for (int aX : x) {
                sb.append(aX).append(" ");
            }
            System.out.println(sb.toString().trim());
        };

        String command = "";
        while (!("end".equals(command = br.readLine()))) {
            if (!"print".equals(command)) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = someFunction.apply(command, numbers[i]);
                }
            } else {
                printThem.accept(numbers);
            }
        }
    }
}
