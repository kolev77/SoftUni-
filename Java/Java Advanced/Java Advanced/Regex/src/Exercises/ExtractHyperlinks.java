package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder html = new StringBuilder();

        String input;
        while (!"END".equals(input = br.readLine())) {
            html.append(input).append(' ');
        }

        Pattern aTagPattern = Pattern.compile("<a((?:.|\\s)*?)>(?:.|\\s)*?<\\/a>");
        Matcher aTagMatcher = aTagPattern.matcher(html);

        ArrayList<String> aTagsContent = new ArrayList<>();
        while (aTagMatcher.find()) {
            aTagsContent.add(aTagMatcher.group(1).trim());
        }

        StringBuilder output = new StringBuilder();
        Pattern hrefPattern = Pattern.compile("href\\s*=\\s*(\\s|'|\")(.*?)\\1");
        for (String aTagContent : aTagsContent) {
            Matcher hrefMatcher = hrefPattern.matcher(aTagContent);
            if (hrefMatcher.find())
                output.append(hrefMatcher.group(2) + "\n");
        }

        System.out.println(output);
    }
}
