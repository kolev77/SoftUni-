package Lab;

import java.util.Scanner;

public class FillingJaggedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] jagged = new int[5][];

        for (int row = 0; row < jagged.length; row++) {
            String[] inputNumbers = scanner.nextLine().split(" ");
            jagged[row] = new int[inputNumbers.length];

            for (int col = 0; col < jagged[row].length; col++) {
                jagged[row][col] = Integer.parseInt(inputNumbers[col]);
            }
        }
    }
}
