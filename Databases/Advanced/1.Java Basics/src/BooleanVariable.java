import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 01-Jul-17.
 */
public class BooleanVariable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean result;
        if (input.equals("True")) {
            result = true;
            System.out.println("Yes");
        } else if (input.equals("False")) {
            result = false;
            System.out.println("No");
        }
    }
}
