package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SmallestNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Function<Integer[], Integer> getMinNumber = integers -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer num : integers) {
                if (num < min)
                    min = num;
            }
            return min;
        };
        System.out.println(getMinNumber.apply(numbers));
    }
}
