import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EarthQuake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<List<Integer>> allNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] numbers = br.readLine().split("\\s+");
            List<Integer> wave = new ArrayList<>();
            for (int j = 0; j < numbers.length; j++) {
                wave.add(Integer.parseInt(numbers[j]));
            }
            allNumbers.addLast(wave);
        }

        while (!allNumbers.isEmpty()) {
            List<Integer> wave = allNumbers.pop();
            int seismicity = wave.get(0);

            for (int i = 1; i < wave.size(); i++) {
                if (seismicity < wave.get(i)) {
                    allNumbers.addLast(wave.subList(i, wave.size()));
                    break;
                }
            }
            result.add(seismicity);
        }
        System.out.println(result.size());
        System.out.println(Arrays.toString(result.toArray()).replaceAll("[\\]\\[,]", ""));
    }
}
