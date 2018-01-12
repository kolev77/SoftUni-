package Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CountWords {
    private final static String input = "/src/resources/BigText.txt";
    private final static String output = "/src/resources/WordsCount.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + input;
        String outputPath = projectPath + output;
        File inputFile = new File(inputPath);
        FileReader fileReader = new FileReader(inputFile);
        HashMap<String, Integer> searchedWords = new HashMap<>();


        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] wordsOnCurrentLine = line.split(" ");
                for (String word : wordsOnCurrentLine) {
                    searchedWords.put(word, 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileReader = new FileReader(outputPath);

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] wordsOnCurrentLine = line.split("\\W+");
                for (String word : wordsOnCurrentLine) {
                    if (searchedWords.containsKey(word)) {
                        searchedWords.put(word.toLowerCase(), searchedWords.get(word) + 1);
                    }
                }
            }

            for (String word : searchedWords.keySet()) {
                System.out.println(word + " - " + searchedWords.get(word));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
