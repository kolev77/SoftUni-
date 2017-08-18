package LAB.Problems;

import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            String currentNum = numbers[i];
            if (!result.containsKey(currentNum)) {
                result.put(currentNum, 1);
            } else {
                result.put(currentNum, result.get(currentNum) + 1);
            }
        }

        for (String key : result.keySet()) {
            System.out.println(key + " - " + result.get(key) + " times");
        }
    }
}
