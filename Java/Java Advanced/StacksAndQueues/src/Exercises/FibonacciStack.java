package Exercises;

import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Rostislav Kolev on 31-Jan-17.
 */
public class FibonacciStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);

        for (int i = 0; i < n; i++) {
            long first = stack.pop();
            long second = stack.pop();
            long nextNum = first + second;
            stack.push(nextNum);
            stack.push(second);
        }
        System.out.println(stack.pop());
    }
}
