package Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlusRemove {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        ArrayList<char[]> lines = new ArrayList<char[]>();
        ArrayList<char[]> result = new ArrayList<char[]>();

        while (!text.equals("END")) {

            lines.add(text.toLowerCase().toCharArray());

            result.add(text.toCharArray());

            text = scanner.nextLine();
        }

        for (int row = 0; row < lines.size(); row++) {

            for (int col = 0; col < lines.get(row).length; col++) {

                FindPluses(lines, result, row, col);

            }

        }

        for (char[] chars : result) {
            for (char aChar : chars) {

                if (aChar != '\0') {

                    System.out.print(aChar);
                }
            }

            System.out.println();
        }

    }

    private static void FindPluses(ArrayList<char[]> lines, ArrayList<char[]> result, int row, int col) {

        char symbol = lines.get(row)[col];

        if (row - 1 >= 0 &&
                row + 1 < lines.size() &&
                col - 1 >= 0 &&
                col + 1 < lines.get(row).length &&
                lines.get(row - 1).length > col &&
                lines.get(row + 1).length > col &&
                lines.get(row - 1)[col] == symbol &&
                lines.get(row + 1)[col] == symbol &&
                lines.get(row)[col - 1] == symbol &&
                lines.get(row)[col + 1] == symbol) {

            result.get(row)[col] = '\0';
            result.get(row - 1)[col] = '\0';
            result.get(row + 1)[col] = '\0';
            result.get(row)[col - 1] = '\0';
            result.get(row)[col + 1] = '\0';
        }

    }
}