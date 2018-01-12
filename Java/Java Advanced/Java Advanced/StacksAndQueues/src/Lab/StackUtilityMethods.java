package Lab;

import java.util.ArrayDeque;

public class StackUtilityMethods {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Integer size = stack.size();
        boolean isEmpty = stack.isEmpty();
        boolean exists = stack.contains(2);

        stack.push(2);
        stack.push(2);
        stack.push(2);

    }
}
