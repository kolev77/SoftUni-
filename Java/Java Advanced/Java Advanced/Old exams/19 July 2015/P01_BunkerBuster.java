import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P01_BunkerBuster {
    private static Set<String> cellDestroyed = new HashSet<>();
    private static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensionsLiengt = reader.readLine().split(" ");
        matrix = new Integer[Integer.parseInt(dimensionsLiengt[0])][Integer.parseInt(dimensionsLiengt[1])];
        readMatrix(reader);

        String command = reader.readLine();
        while (!command.equals("cease fire!")) {
            String[] reminder = command.split(" ");
            Integer inpactRow = Integer.parseInt(reminder[0]);
            Integer inpactCol = Integer.parseInt(reminder[1]);
            Integer damage = String.valueOf(reminder[2]).codePointAt(0);
            bombImpact(inpactRow, inpactCol, damage);
            command = reader.readLine();
        }

        System.out.println("Destroyed bunkers: " + cellDestroyed.size());
        Double percent = (double)(cellDestroyed.size() * 100.0f) / (matrix.length * matrix[0].length);
        String output = String.format("%.1f", percent);
        System.out.println("Damage done: " + output + " %");
    }

    private static void bombImpact(Integer inpactRow, Integer inpactCol, Integer damage) {
            cellDamage(inpactRow, inpactCol, damage);
            if (damage % 2 == 0) {
                damage /= 2;
            } else {
                damage = (damage / 2) + 1;
            }
            cellDamage(inpactRow + 1, inpactCol, damage);
            cellDamage(inpactRow + 1, inpactCol + 1, damage);
            cellDamage(inpactRow, inpactCol + 1, damage);
            cellDamage(inpactRow - 1, inpactCol + 1, damage);
            cellDamage(inpactRow - 1, inpactCol, damage);
            cellDamage(inpactRow - 1, inpactCol - 1, damage);
            cellDamage(inpactRow, inpactCol - 1, damage);
            cellDamage(inpactRow + 1, inpactCol - 1, damage);
    }

    private static void cellDamage(Integer inpactRow, Integer inpactCol, Integer damage) {
        try {
            matrix[inpactRow][inpactCol] -= damage;
            if (matrix[inpactRow][inpactCol] <= 0) {
                cellDestroyed.add(inpactRow.toString() + inpactCol.toString());
            }
        } catch (IndexOutOfBoundsException ex) {}
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] colNumbers = reader.readLine().split(" ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(colNumbers[col]);
            }
        }
    }
}
