package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)(?:[^a-zA-Z+]*?)(\\+?\\d[\\d()./\\- ]*\\d)");
        String input = br.readLine();
        StringBuilder result = new StringBuilder("<ol>");


        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group(1);
                char[] number = matcher.group(2).toCharArray();
                String realNum = "";
                String numbers = "+0123456789";
                for (char digit : number) {
                    if (numbers.contains(String.valueOf(digit))) {
                        realNum += digit;
                    }
                }
                result.append("<li><b>" + name + ":</b> " + realNum + "</li>");
            }
            input = br.readLine();
        }
        if (result.length() < 5) {
            System.out.println("<p>No matches!</p>");
        } else {
            result.append("</ol>");
            System.out.println(result);
        }
    }
}
