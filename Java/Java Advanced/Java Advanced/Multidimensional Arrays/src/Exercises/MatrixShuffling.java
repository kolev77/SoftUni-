package Exercises;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.equals("END")) break;

            String[] commandData = input.split(" ");

            if (!commandData[0].equals("swap") || commandData.length != 5) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(commandData[1]);
                int col1 = Integer.parseInt(commandData[2]);
                int row2 = Integer.parseInt(commandData[3]);
                int col2 = Integer.parseInt(commandData[4]);

                try {
                    matrix = swapElements(matrix, row1, col1, row2, col2);
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }
            }
        }
    }

    static String[][] swapElements(String[][] matrix, int row1, int col1, int row2, int col2) {
        boolean valid = true;
        try {
            String oldElement = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = oldElement;
        } catch (Exception e) {
            System.out.println("Invalid input!");
            valid = false;
        }
        if (valid) printStringMatrix(matrix);
        return matrix;
    }

    static void printStringMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.println(String.join(" ", strings));
        }
    }
}

/*
2 3
1 2 3
4 5 6
swap 0 0 1 1
swap 10 9 8 7
swap 0 1 1 0
END
 */
