package Lab.Problems;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, children);
        int counter = 1;

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String firstChild = queue.poll();
                queue.offer(firstChild);

            }
            if (IsPrime(counter)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());

            }
        counter++;
        }
        System.out.println("Last is " + queue.poll());
    }
    private static boolean IsPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int divider = 2; divider <= Math.sqrt(number); divider++) {
            if (number % divider == 0) {
                return false;
            }
        }
        return true;
    }

}
