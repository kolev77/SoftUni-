import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 01-Jul-17.
 */
public class VariableInHexFormat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hex = br.readLine();

        System.out.println(Integer.parseInt(hex,16));
    }
}
