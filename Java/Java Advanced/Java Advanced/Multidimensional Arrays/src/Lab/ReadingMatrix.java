package Lab;

import java.util.Scanner;

public class ReadingMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                System.out.println(
                        String.format("matrix[%1$d][%2$d] = ", row, column));
                String inputNumber = scanner.nextLine();
                matrix[row][column] = Integer.parseInt(inputNumber);
            }
        }
    }
}
