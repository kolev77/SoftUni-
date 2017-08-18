import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class IndexLetter {
    public static void main(String[] args) throws IOException {
        //    from 97 to 22
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " -> "+ Integer.valueOf(input[i]-97) );
        }
    }
}