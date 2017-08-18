package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine().toLowerCase());
        String searched = br.readLine().toLowerCase();
        int counter = 0;
        for (int charWordInText = 0; charWordInText < input.length() - searched.length() + 1; charWordInText++) {
            int currentCounter = searched.length();
            for (int charSearched = 0; charSearched < searched.length(); charSearched++) {
                if (input.charAt(charWordInText + charSearched) == searched.charAt(charSearched))
                    currentCounter--;

                if (currentCounter == 0)
                    counter++;
            }
        }
        System.out.println(counter);
    }
}
