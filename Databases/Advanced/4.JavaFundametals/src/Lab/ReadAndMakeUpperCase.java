package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Rostislav Kolev on 07-Jul-17.
 */
public class ReadAndMakeUpperCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Arrays.stream(input).forEach(x -> System.out.print(x.toUpperCase()+" "));

    }
}
