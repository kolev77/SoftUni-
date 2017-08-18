package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class FindSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        ArrayList<Integer> numbers = new ArrayList<>();
        Arrays.stream(input).forEach(x -> numbers.add(Integer.valueOf(x)));
        Function<ArrayList<Integer>, Integer> findIt = x -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number < min)
                    min = number;
            }
            return min;
        };
        Integer min = findIt.apply(numbers);
        System.out.println(numbers.indexOf(min));

    }
}
