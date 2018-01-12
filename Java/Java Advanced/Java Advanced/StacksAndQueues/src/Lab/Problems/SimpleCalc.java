package Lab.Problems;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] tokens = input.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack,tokens);  // Adding in reverse order

        while (stack.size() > 1) {
            Integer first = Integer.valueOf(stack.pop());
            String operator = stack.pop();
            Integer second = Integer.valueOf(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}
