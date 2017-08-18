import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class CountOfOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer number = numbers[i];
            if (!occurrences.containsKey(number)) {
                occurrences.put(number, 1);
            } else {
                occurrences.put(number, occurrences.get(number) + 1);
            }
        }

        for (Integer number : occurrences.keySet()) {
            System.out.printf("%d -> %d times\n",number,occurrences.get(number));
        }
    }
}
