package Exercises;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        TreeMap<Character, Integer> counter = new TreeMap<>();
        for (int i = 0; i < input.length; i++) {
            if (!counter.containsKey(input[i])) {
                counter.put(input[i], 1);
            } else {
                counter.put(input[i], counter.get(input[i]) + 1);
            }
        }
        for (Character character : counter.keySet()) {
            System.out.println(character + ": " + counter.get(character) + " time/s");
        }
    }
}
