package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int n = Integer.valueOf(data[0]); // elements to push
        int s = Integer.valueOf(data[1]); // elements to pop
        int x = Integer.valueOf(data[2]); // Check whether is present in the stack

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] numData = scanner.nextLine().split(" ");

        for (int i = 0; i < n - s; i++) {
            stack.push(Integer.valueOf(numData[i]));
        }
        if (!stack.isEmpty()) {

//        for (int i = 0; i < s; i++) {     // We`ve done this in the upper cycle
//            stack.pop();
//        }
            boolean findedX = false;
            int smallestElement = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int currentVal = stack.pop();
                if (currentVal == x) {
                    findedX = true;
                }
                if (currentVal < smallestElement) {
                    smallestElement = currentVal;
                }
            }
            if (findedX) System.out.println(findedX);
            else
                System.out.println(smallestElement);
        }else {
            System.out.println(0);
        }
    }
}
