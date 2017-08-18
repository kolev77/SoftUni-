import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class LongestSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int count = 1;
        int maxLength = 1;
        int element = numbers[0];

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                count++;
                if (count > maxLength) {
                    maxLength = count;
                    element = numbers[i];
                }
            } else
                count = 1;
        }

        for (int i = 0; i < maxLength; i++) {
            System.out.print(element + " ");
        }
    }
}
