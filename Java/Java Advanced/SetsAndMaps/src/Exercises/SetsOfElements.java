package Exercises;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(" ");
        int n = Integer.valueOf(sizes[0]);
        int m = Integer.valueOf(sizes[1]);
        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                first.add(Integer.valueOf(scanner.nextLine()));
            } else {
                second.add(Integer.valueOf(scanner.nextLine()));
            }
        }

        for (Integer num : first) {
            if (second.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
