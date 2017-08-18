import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        for (int i = input.length-1; i >= 0 ; i--) {
            System.out.print(input[i]);
        }
    }
}
