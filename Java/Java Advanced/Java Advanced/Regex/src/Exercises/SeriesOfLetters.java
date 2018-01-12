package Exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Pattern pattern = Pattern.compile("([A-Za-z])\\1+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find())
            input = matcher.replaceAll("$1"); // Take only one letter and insert it to capturing group. After it, we find the whole match and replace it with the single letter taken from it`s capturing group.

        System.out.println(input);
    }
}