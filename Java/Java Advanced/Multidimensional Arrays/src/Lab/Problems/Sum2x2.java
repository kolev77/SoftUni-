package Lab.Problems;

import java.util.Scanner;

public class Sum2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputData = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++)
                matrix[row][col] = Integer.parseInt(inputData[col]);
        }
        int maxSum = 0;
        int[][] bestPart = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentCell = matrix[row][col];
                int onRight = matrix[row][col + 1];
                int bottom = matrix[row + 1][col];
                int bottomRight = matrix[row + 1][col + 1];
                int currentSum = currentCell + onRight + bottom + bottomRight;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestPart[0][0] = currentCell;
                    bestPart[0][1] = onRight;
                    bestPart[1][0] = bottom;
                    bestPart[1][1] = bottomRight;
                }
            }
        }
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++)
                System.out.print(bestPart[row][col] + " ");
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
