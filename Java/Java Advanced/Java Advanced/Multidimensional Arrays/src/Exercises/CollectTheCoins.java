package Exercises;

import java.util.Scanner;

public class CollectTheCoins {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[4][];
        for (int row = 0; row < 4; row++) {
            matrix[row] = scanner.nextLine().split("");
        }

        String[] commands = scanner.nextLine().split("");

        int currentRow = 0;
        int currentCol = 0;

        int collectedCoins = 0;
        int wallsHit = 0;

        if (matrix[0][0].equals("$")) {
            collectedCoins++;
        }

        for (String command : commands) {
            String token = "";

            if (command.equals(">")) {
                try {
                    currentCol += 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {

                    currentCol--;
                    wallsHit++;
                }
            } else if (command.equals("<")) {
                try {
                    currentCol -= 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    currentCol++;
                    wallsHit++;
                }
            } else if (command.equals("V")) {
                try {
                    currentRow += 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    currentRow--;
                    wallsHit++;
                }
            } else if (command.equals("^")) {
                try {
                    currentRow -= 1;
                    token = matrix[currentRow][currentCol];
                } catch (Exception e) {
                    currentRow++;
                    wallsHit++;
                }
            }
            if (token.equals("$")) {
                collectedCoins++;
            }
            token = "";
        }
        System.out.println("Coins = " + collectedCoins);
        System.out.println("Walls = " + wallsHit);
    }
}




