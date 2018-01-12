package Lab.Problems;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class SpecialWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] specialWords = scanner.nextLine().split(" ");
        HashMap<String, Integer> result = new HashMap<>();
        for (String specialWord : specialWords) {
            result.put(specialWord, 0);
        }

        String[] input = scanner.nextLine().split(" ");

        for (String currentWord : input) {
            if (result.containsKey(currentWord)) {
                result.put(currentWord, result.get(currentWord) + 1);
            }
        }

        for (String word : result.keySet()) {
            System.out.println(word + " - " + result.get(word));
        }
    }
}
