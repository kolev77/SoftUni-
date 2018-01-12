package LAB.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(x -> Integer.valueOf(x)).toArray();
        Arrays.stream(nums).distinct()
                .filter(x -> 10 <= x && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
