import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class CensorEmail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] email = br.readLine().split("@");
        String username = email[0];
        String input = br.readLine();

        String replacement = drawStars(username) + "@" + email[1];
        input = input.replace(email[0]+"@"+email[1],replacement);

        System.out.println(input);
    }

    private static String drawStars(String username) {
        String censoredUsername = "";

        for (int i = 0; i < username.length(); i++) {
            censoredUsername += "*";
        }
        return censoredUsername;
    }
}
