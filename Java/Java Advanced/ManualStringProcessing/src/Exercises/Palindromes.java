package Exercises;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("[ ,.?!]");

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.equals("")){
                continue;
            }

            boolean isPalindrome = true;

            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                result.add(word);
            }
        }
        Collections.sort(result,Collator.getInstance(Locale.ENGLISH));
        System.out.println(result);
    }
}
