package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.valueOf(x)).toArray();
        int divider = Integer.valueOf(br.readLine());

        Predicate<Integer> task = x -> x % divider != 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (task.test(numbers[i])) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
