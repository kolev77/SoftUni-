package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] braces = scanner.nextLine().toCharArray();
        if (braces.length % 2 != 0) {
            System.out.println("NO");
            return;
        }
        ArrayDeque<Character> openBraces = new ArrayDeque<>();

        boolean balanced = true;
        for (char brace : braces) {
            if (brace == '{' || brace == '[' || brace == '(') {
                openBraces.push(brace);
            } else {
                char currentBrace = openBraces.pop();
                if (currentBrace == '{' && brace == '}' || currentBrace == '[' && brace == ']' || currentBrace == '(' && brace == ')') {
                    balanced = true;
                } else {
                    balanced = false;
                    System.out.println("NO");
                    break;
                }
            }
        }
        if (balanced == true) {
            System.out.println("YES");
        }
    }
}
