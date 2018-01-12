package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmailsFASTER {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern =
                Pattern.compile
                        ("(?<=^| )([a-zA-Z]+[\\w.-]*[^.-_])@([a-zA-Z]+[a-zA-Z-]*(?:\\.[a-zA-Z]+[a-zA-Z-]*)+)(?= |\\.|,|$)");

        StringBuilder output = new StringBuilder();

        String input;
        while (!"end".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                output.append(matcher.group(0)).append(System.lineSeparator());
            }
        }

        System.out.print(output);
    }
}