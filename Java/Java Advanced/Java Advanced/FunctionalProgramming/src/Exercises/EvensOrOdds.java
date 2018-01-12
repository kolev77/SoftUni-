package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class EvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer lowRange = Integer.valueOf(input[0]);
        Integer highRange = Integer.valueOf(input[1]);
        String condition = br.readLine();
        Integer[] numbers = new Integer[highRange - lowRange + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = lowRange + i;
        }

        if (condition.equals("odd"))
            filter(numbers, x -> x % 2 != 0);
        else if (condition.equals("even"))
            filter(numbers, x -> x % 2 == 0);
    }

    private static void filter(Integer[] numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
