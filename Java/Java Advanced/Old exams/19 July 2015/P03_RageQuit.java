import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P03_RageQuit {
    private static Set<Character> counter = new LinkedHashSet<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(input);
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(input);
        int readyIndex = 0;

        while (matcher.find()) {
            String digit = matcher.group(1);
            Integer index = input.indexOf(digit, readyIndex);
            String reminder = sb.substring(readyIndex, index);
            reminder = reminder.toUpperCase();

            countSymbols(reminder);
            appendToResult(reminder, Integer.parseInt(digit));

            if (digit.length() == 1) {
                readyIndex = index + 1;
            } else {
                readyIndex = index + 2;
            }
        }

        result.append(sb.substring(readyIndex).toUpperCase());

        List<Character> chars = result.toString().chars().mapToObj(e->(char)e).collect(Collectors.toList());
        chars.stream().distinct().forEach(n -> System.out.println(n));
        counter.forEach(n -> System.out.println(n));
        long count = chars.stream().distinct().count();
        System.out.println("Unique symbols used: " + count);
        System.out.println(result);
    }

    private static void appendToResult(String reminder, Integer digit) {
        for (int i = 0; i < digit; i++) {
            result.append(reminder);
        }
    }

    private static void countSymbols(String reminder) {
        for (Character character : reminder.toCharArray()) {
            //if (character.equals(' ')) {
            //    continue;
            //} else {
                counter.add(character);
            //}
        }
    }
}
