import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 06-Jun-17.
 */
public class sol {
    public static void main(String[] args) throws IOException {
        int n = 2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] lab = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                lab[j][i] = line[i];
            }
        }
    }
}
