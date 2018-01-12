package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$");
        String text = br.readLine();

        while (!text.equals("END")) {
            Matcher matcher = pattern.matcher(text);
            if (matcher.find())
                if (isValidTime(matcher))
                    System.out.println("valid");
                else
                    System.out.println("invalid");
            else
                System.out.println("invalid");
            text = br.readLine();
        }
    }

    private static boolean isValidTime(Matcher matcher) {
        int hours = Integer.valueOf(matcher.group(1));
        int mins = Integer.valueOf(matcher.group(2));
        int seconds = Integer.valueOf(matcher.group(3));
        if (1 <= hours && hours <= 12 && 0 <= mins && mins <= 59 && 0 <= seconds && seconds <= 59) {
            return true;
        } else
            return false;
    }
}
