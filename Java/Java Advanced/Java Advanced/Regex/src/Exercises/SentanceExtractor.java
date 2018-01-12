package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentanceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String keyword = br.readLine();
        String text = br.readLine();
        Pattern pattern = Pattern.compile("(?<=\\s|^)[^!.?]*\\b"+ keyword +"\\b[^!.?]*[!.?]");
        Matcher matcher= pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
