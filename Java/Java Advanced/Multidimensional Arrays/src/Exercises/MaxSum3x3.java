package Exercises;

import java.util.Scanner;

public class MaxSum3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = readMatrix(rows, cols, scanner);

        int targetRow = 0;
        int targetCol = 0;
        int bestSum = Integer.MIN_VALUE;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > bestSum) {
                    bestSum = sum;
                    targetRow = row;
                    targetCol = col;
                }
            }
        }
        System.out.println("Sum = " + bestSum);

        for (int row = targetRow; row <= targetRow + 2; row++) {
            for (int col = targetCol; col <= targetCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] data = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(data[col]);
            }
        }
        return matrix;
    }
}
