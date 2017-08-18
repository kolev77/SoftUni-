package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTags {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(<a href=\")(?:\\n*.+?)(\">)(?:\\n*[a-zA-Z]+)(\\n*<\\/a>)");
        String result = "";
        String input = br.readLine();

        while (!input.equals("END")) {
            result += input +"\n";
            input = br.readLine();
        }
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            String openTag = matcher.group(1);
            String midCloseTag = matcher.group(2);
            String closeTag = matcher.group(3);
            result = result.replace(openTag, "[URL href=\"");
            result = result.replace(midCloseTag, "\"]");
            result = result.replace(closeTag, "[/URL]");
        }
        System.out.println(result);
    }
}
