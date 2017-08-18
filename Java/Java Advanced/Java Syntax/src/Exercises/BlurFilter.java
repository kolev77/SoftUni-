package Exercises;

import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurFilter = Integer.parseInt(scanner.nextLine());
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        long[][] pixels = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                pixels[row][col] = Long.parseLong(inputData[col]);
            }
        }
        String[] coordinates = scanner.nextLine().split("\\s+");
        int targetRow = Integer.parseInt(coordinates[0]);
        int targetCol = Integer.parseInt(coordinates[1]);

        int onLeft = Math.max(0, targetCol - 1);
        int onRight = Math.min(targetCol + 1, cols);
        int onTop = Math.max(targetRow-1, 0);
        int onBottom = Math.min(targetRow + 1, rows);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((onLeft <= col && col <= onRight) && onTop <= row && row <= onBottom) {
                    System.out.printf("%d ", pixels[row][col] + blurFilter);
                } else {
                    System.out.printf("%d ", pixels[row][col]);
                }
            }
            System.out.println();
        }
    }
}
