package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        LinkedHashSet<String> result = new LinkedHashSet<>();

        // Read input
        while (!input.equals("end")) {
            String[] dataLine = input.split(" |, ");
            Arrays.stream(dataLine).filter(x -> x.contains("@")).forEach(x -> result.add(x));

            input = br.readLine();
        }

        Pattern pattern = Pattern.compile("^(?![_.-])(?<user>[a-zA-z.]+[- _]*)+@([A-Za-z]+-*[A-Za-z]+)\\.[a-zA-z\\.*]+$");
        for (String email : result) {
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                if (matcher.group().charAt(matcher.group().length() - 1) == '.') {
                    System.out.println(matcher.group().substring(0, matcher.group().length() - 1));
                } else
                    System.out.println(matcher.group());
            }
        }
    }
}
