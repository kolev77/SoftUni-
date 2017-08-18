package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> reversed = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            reversed.push(input[i]);
        }
        for (int i = 0; i < reversed.size(); i++) {
            System.out.print(reversed.toArray()[i] + " ");
        }
    }
}
