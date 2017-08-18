package Lab.Problems;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());

        long[][] pascal = new long[height][];

        for (int i = 0; i < height; i++) {
            pascal[i] = new long[i + 1];
        }
        pascal[0][0] = 1;

        for (int row = 1; row < height; row++) { // starts from 1
            pascal[row][0] = 1;  // first element of row
            pascal[row][pascal[row].length - 1] = 1; // last element of row
            for (int col = 1; col < pascal[row].length - 1; col++) {
                pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
            }
        }

        for (long[] row : pascal) {
            for (long num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
