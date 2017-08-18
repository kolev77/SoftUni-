import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 02-Jul-17.
 */
public class MostFreqNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] sequence = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        LinkedHashMap<Integer, Integer> occurancies = new LinkedHashMap<>();

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            if (!occurancies.containsKey(current)) {
                occurancies.put(current, 1);
            } else {
                occurancies.put(current, occurancies.get(current) + 1);
            }
        }

        int freqNum = 0;
        int frequency = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : occurancies.entrySet()) {
           if (frequency < integerIntegerEntry.getValue()){
               frequency = integerIntegerEntry.getValue();
               freqNum = integerIntegerEntry.getKey();
           }
        }
        System.out.println(freqNum);
    }
}
