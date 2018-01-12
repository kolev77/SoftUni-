package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class BiggestSmallest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(input).forEach(x -> numbers.add(Integer.valueOf(x)));

        String command = br.readLine();


        Function<List<Integer>, Integer> minEven = integers -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer integer : integers) {
                if (integer % 2 == 0 && integer < min) {
                    min = integer;
                }
            }
            return min;
        };

        Function<List<Integer>, Integer> maxEven = integers -> {
            Integer max = Integer.MIN_VALUE;
            for (Integer integer : integers) {
                if (integer % 2 == 0 && integer > max) {
                    max = integer;
                }
            }
            return max;
        };

        Function<List<Integer>, Integer> minOdd = integers -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer integer : integers) {
                if (integer % 2 == 1 && integer < min) {
                    min = integer;
                }
            }
            return min;
        };

        Function<List<Integer>, Integer> maxOdd = integers -> {
            Integer max = Integer.MIN_VALUE;
            for (Integer integer : integers) {
                if (integer % 2 == 1 && integer > max) {
                    max = integer;
                }
            }
            return max;
        };
        if (command.equals("minEven")) {
            System.out.println(numbers.indexOf(minEven.apply(numbers)));
        } else if (command.equals("maxEven")) {
            System.out.println(numbers.indexOf(maxEven.apply(numbers)));
        } else if (command.equals("minOdd")) {
            System.out.println(numbers.indexOf(minOdd.apply(numbers)));
        } else if (command.equals("maxOdd")) {
            System.out.println(numbers.indexOf(maxOdd.apply(numbers)));
        }
    }
}
