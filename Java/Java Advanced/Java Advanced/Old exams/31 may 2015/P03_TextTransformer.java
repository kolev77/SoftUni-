import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_TextTransformer {
    public static void main(String[] args) throws IOException {
        Pattern capturePattern = Pattern.compile("([$%&'])([^$%&']+)\\1");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();
        String checker = reader.readLine();

        while (!checker.equals("burp")) {
            input.append(checker);
            checker = reader.readLine();
        }

        String rem = input.toString().trim().replaceAll("\\s{2,}", " ");
        Matcher matcher = capturePattern.matcher(rem);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String symbol = matcher.group(1);
            String match = matcher.group(2);
            result.append(decodeString(symbol, match));
            result.append(" ");
        }

        System.out.println(result);
    }

    private static String decodeString(String symbol, String input) {
        char[] array = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int number = getNumber(symbol);

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                char rem = array[i];
                rem += number;
                result.append(rem);
            } else {
                char rem = array[i];
                rem -= number;
                result.append(rem);
            }
        }

        return result.toString();
    }

    private static int getNumber(String symbol) {
        switch (symbol) {
            case "$":
                return 1;
            case "%":
                return 2;
            case "&":
                return 3;
            case "'":
                return 4;
            default:
                return 0;
        }
    }
}
