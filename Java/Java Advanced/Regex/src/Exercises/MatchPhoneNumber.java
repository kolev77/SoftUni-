package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("^\\+359([ -])\\d\\1\\d{3}\\1\\d{4}$");
        String input = br.readLine();

        while (!input.equals("end")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            input = br.readLine();
        }
    }
}
