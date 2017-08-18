import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Rostislav Kolev on 01-Jul-17.
 */
public class ReverseCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] result = new String[3];
        for (int i = 0; i < 3; i++) {
            String letter = br.readLine();
            result[i] = letter;
        }
        for (int i = result.length-1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }
}
