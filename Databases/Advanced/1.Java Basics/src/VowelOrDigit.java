import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rostislav Kolev on 01-Jul-17.
 */
public class VowelOrDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character input = br.readLine().charAt(0);
        ArrayList<Character> vowels = new ArrayList<Character>(
                Arrays.asList('a', 'e', 'i', 'o', 'u'));

        if (vowels.contains(input)) {
            System.out.println("vowel");
        } else if (Integer.valueOf(input) >= 48 && Integer.valueOf(input) <= 58) {
            System.out.println("digit");
        } else
            System.out.println("other");
    }
}
