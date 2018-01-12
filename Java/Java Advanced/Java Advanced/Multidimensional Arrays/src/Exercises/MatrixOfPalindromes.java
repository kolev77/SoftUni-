package Exercises;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);
        String[][] matrix = new String[rows][cols];
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.format("%c%c%c", alphabet[row], alphabet[row + col], alphabet[row]);
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
