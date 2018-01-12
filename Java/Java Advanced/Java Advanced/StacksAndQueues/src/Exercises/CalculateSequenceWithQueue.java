package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = Long.valueOf(scanner.nextLine());
        ArrayDeque<Long> sequence = new ArrayDeque<>();
        sequence.add(num);

        for (int i = 0; i < 50; i++) {
            Long element = sequence.poll();
            System.out.print(element + " ");
            Long s2 = element + 1;
            Long s3 = element * 2 + 1;
            Long s4 = element + 2;
            sequence.add(s2);
            sequence.add(s3);
            sequence.add(s4);
        }
    }
}
