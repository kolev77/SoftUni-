import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunkerBuster {
    private static int[][] matrix;
    private static int counter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] matrixSize = br.readLine().split("\\s+");
        int rows = Integer.valueOf(matrixSize[0]);
        int cols = Integer.valueOf(matrixSize[1]);
        matrix = new int[rows][cols];
        readMatrix(br, rows, matrix);


        String command = br.readLine();

        while (!command.equals("cease fire!")) {
            String[] bombInfo = command.split("\\s+");
            int bombRow = Integer.valueOf(bombInfo[0]);
            int bombCol = Integer.valueOf(bombInfo[1]);
            int bombFullPower = (int) Character.valueOf(bombInfo[2].charAt(0));
            int bombHalfPower = (int) Math.ceil(bombFullPower / 2.0);
            cellDamage(bombRow, bombCol, bombFullPower);
            cellDamage(bombRow, bombCol + 1, bombHalfPower);
            cellDamage(bombRow + 1, bombCol + 1, bombHalfPower);
            cellDamage(bombRow + 1, bombCol, bombHalfPower);
            cellDamage(bombRow + 1, bombCol - 1, bombHalfPower);
            cellDamage(bombRow, bombCol - 1, bombHalfPower);
            cellDamage(bombRow - 1, bombCol - 1, bombHalfPower);
            cellDamage(bombRow - 1, bombCol, bombHalfPower);
            cellDamage(bombRow - 1, bombCol + 1, bombHalfPower);

            command = br.readLine();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] <= 0) {
                    counter++;
                }
            }

        }
        System.out.println("Destroyed bunkers: " + counter);
        Double destroyed = 100.0 * counter / (rows * cols);
        System.out.println(String.format("Damage done: %.1f", destroyed) + " %");


    }

    private static void cellDamage(int bombRow, int bombCol, int bombPower) {
        try {
            matrix[bombRow][bombCol] -= bombPower;
        } catch (Exception e) {

        }
    }

    private static void readMatrix(BufferedReader br, int rows, int[][] matrix) throws IOException {
        for (int i = 0; i < rows; i++) {
            String[] line = br.readLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
