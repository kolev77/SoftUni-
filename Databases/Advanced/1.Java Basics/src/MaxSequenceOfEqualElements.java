import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 02-Jul-17.
 */
public class MaxSequenceOfEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] sequence = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer bestLen = 0;
        Integer bestStart = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            int currentLen = 1;
            int currentNum = sequence[i];
            for (int j = i + 1; j < sequence.length; j++) {
                int nextNum = sequence[j];

                if (currentNum == nextNum) {
                    currentLen++;
                } else {
                    break;
                }
            }
            if (currentLen > bestLen) {
                bestLen = currentLen;
                bestStart = i;
            }
        }

        for (int i = 0; i < bestLen; i++) {
            System.out.print(sequence[bestStart] + " ");
        }
    }
}
