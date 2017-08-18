import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 01-Jul-17.
 */
public class IntToHexAndBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer input = Integer.valueOf(br.readLine());
        System.out.println(Integer.toHexString(input).toUpperCase());
        System.out.println(Integer.toBinaryString(input));

    }
}
