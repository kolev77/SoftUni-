import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Pattern pattern = Pattern.compile("(\\D+)(\\d+)");
        HashSet<Character> uniqueChars = new HashSet<>();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            Integer count = Integer.parseInt(matcher.group(2));
            String str = matcher.group(1).toUpperCase();

            if (count != 0) {
                for (int i = 0; i < str.length(); i++) {
                    uniqueChars.add(str.charAt(i));
                }
            }

            for (int i = 0; i < count; i++) {
                sb.append(str);
            }
        }
        System.out.println("Unique symbols used: " + uniqueChars.size());
        System.out.println(sb.toString());

    }
}
