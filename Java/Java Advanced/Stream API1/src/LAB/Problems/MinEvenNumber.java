package LAB.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Optional<Double> min = Arrays.stream(input)
                .filter(x -> !x.isEmpty())
                .map(x -> Double.parseDouble(x))
                .filter(x -> x % 2 == 0)
                .min((x, y) -> Double.compare(x, y));

        if (min.isPresent())
            System.out.printf("%.2f", min.get());
        else
            System.out.println("No match");
    }
}
