package Exercises;

import java.io.*;
import java.util.*;

public class CountCharacterTypes {
    private final static String input = "/src/resources/AllCapitalsInput.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Character[] vowelsArr = {'a', 'e', 'i', 'o', 'u'};
        Character[] puncMarksArr = {',', '.', '!', '?'};
        HashSet<Character> vowels = new HashSet<>();
        HashSet<Character> marks = new HashSet<>();
        Collections.addAll(vowels, vowelsArr);
        Collections.addAll(marks, puncMarksArr);

        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + input;
        File inputFile = new File(inputPath);
        FileReader fileReader = new FileReader(inputFile);

        int totalVowels = 0;
        int totalConsonants = 0;
        int totalMarks = 0;

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();

            while (line != null) {
                for (char ch : line.toCharArray()) {
                    if (vowels.contains(ch)) {
                        totalVowels++;
                    } else if (marks.contains(ch))
                        totalMarks++;
                    else {
                        if (ch != ' ')
                            totalConsonants++;
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Vowels: " + totalVowels);
            System.out.println("Consonants: " + totalConsonants);
            System.out.println("Punctuation: " + totalMarks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
