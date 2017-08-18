package Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        char pattern = input[1].toUpperCase().trim().toCharArray()[0];
        int size = Integer.parseInt(input[0].trim());

        if (pattern == 'A') {
            int[][] matrix = fillA(size);
            printMatrix(matrix, size);
        } else if (pattern == 'B') {
            int[][] matrix = fillB(size);
            printMatrix(matrix, size);
        }
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[col][row] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillA(int size) {
        int[][] matrix = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[col][row] = counter++;
            }
        }
        return matrix;
    }

    private static int[][] fillB(int size) {
        int[][] matrix = new int[size][size];
        int counter = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[col][row] = counter++;
                }
            } else if (col % 2 == 1) {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[col][row] = counter++;
                }
            }
        }
        return matrix;
    }
}
