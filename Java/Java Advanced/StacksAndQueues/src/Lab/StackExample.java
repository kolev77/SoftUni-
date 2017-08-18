package Lab;

import java.util.ArrayDeque;

/**
 * Created by Rostislav Kolev on 26-Jan-17.
 */
public class StackExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println("DELETE -> " + stack.peek());
        stack.remove();
        System.out.println(stack);
    }
}
