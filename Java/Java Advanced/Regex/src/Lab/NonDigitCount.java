package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NonDigitCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        System.out.println("Non-digit: " + count);
    }
}
