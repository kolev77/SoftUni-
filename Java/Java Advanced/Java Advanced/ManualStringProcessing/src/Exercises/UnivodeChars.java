package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnivodeChars {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final String input = reader.readLine();
        StringBuilder output = new StringBuilder("");

        for (char c : input.toCharArray()) {
            int code = (int) c;
            output.append(String.format("\\u%04x", (int) c));
        }
        System.out.println(output);
    }

}
