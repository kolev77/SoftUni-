import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 10-Jul-17.
 */
public class example {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (Integer.valueOf(input[i]) < 0) {
                return;
            }
            numbers.add(Integer.valueOf(input[i]));
        }
        int size = 0;
        while (numbers.size() != size) {
            size = numbers.size();
            for (int i = 0; i < numbers.size(); i++) {
                int prev = 0;
                int next = 0;

                if (!numbers.get(i - 1).equals(null)) {
                    prev = numbers.get(i - 1);
                }
                int curr = numbers.get(i);
                if (!numbers.get(i + 1).equals(null)) {
                    next = numbers.get(i + 1);
                }
                if (curr == prev + next) {
                    if (!numbers.get(i - 1).equals(null)) {
                        numbers.remove(i - 1);
                        numbers.remove(i);
                    } else if (numbers.get(i - 1).equals(null)) {
                        numbers.remove(i + 1);
                    }
                    if (!numbers.get(i + 1).equals(null)) {
                        numbers.remove(i + 1);
                    }


                }

            }
        }
        numbers.forEach(x -> System.out.print(x + " "));

    }

}