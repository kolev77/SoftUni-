package Exercises;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        int primarySum = 0;
        int secondarySum = 0;

        for (int i = 0; i < size; i++) {
            primarySum += matrix[i][i];
            secondarySum += matrix[i][size - 1 - i];
        }
        int difference = Math.abs(primarySum - secondarySum);
        System.out.println(difference);
    }
}
