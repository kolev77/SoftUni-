package Exercises;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> unique = new TreeSet<>();
        int elements = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < elements; i++) {
            String[] element = scanner.nextLine().split(" ");
            for (int j = 0; j < element.length; j++) {
                unique.add(element[j]);
            }
        }
        for (String el : unique) {
            System.out.print(el + " ");
        }
    }
}
