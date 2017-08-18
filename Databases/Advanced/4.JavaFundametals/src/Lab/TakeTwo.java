package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 07-Jul-17.
 */
public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] sequence = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        sequence = Arrays.stream(sequence).filter(x -> x >= 10 && x <= 20).distinct()
                .limit(2).toArray(Integer[]::new);

        Arrays.stream(sequence).forEach(x-> System.out.print(x+" "));
    }

}
