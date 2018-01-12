package LAB.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

public class FindAndSumINtegersr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Optional<Integer> sum = Arrays.stream(input)
                .filter(x -> isNumber(x))
                .map(Integer::valueOf)
                .reduce((x, y) -> x + y);

        if (sum.isPresent())
            System.out.println(sum.get());
        else
            System.out.println("No match");
    }

    public static boolean isNumber(String element) {
        try {
            Integer num = Integer.valueOf(element);
        } catch (NumberFormatException error) {
            return false;
        }
        return true;
    }
}
