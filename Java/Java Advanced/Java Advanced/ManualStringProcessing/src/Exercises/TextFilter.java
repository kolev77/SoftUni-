package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = br.readLine().split(", ");
        StringBuilder text = new StringBuilder(br.readLine());


        for (String bannedWord : bannedWords) {
            int index = text.indexOf(bannedWord);
            while (index != -1) {
                for (int i = index; i < index + bannedWord.length(); i++) {
                    text = text.replace(i, i + 1, "*");
                }
                index = text.indexOf(bannedWord);
            }
        }
        System.out.println(text);
    }
}
