package Lab.Problems;

import java.util.Scanner;

public class GroupNumbersWithArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");
        int[] sizes = new int[3];
        int[] offsets = new int[3];

        for (String number : numbers) {
            int reminder = Integer.parseInt(number) % 3;
            sizes[reminder]++;
        }
        int[][] numbersByRemainder =
                {new int[sizes[0]], new int[sizes[1]], new int[sizes[2]]};

        for (String number : numbers) {
            int reminder =Integer.parseInt(number) % 3;
            int index = offsets[reminder];
            numbersByRemainder[reminder][index] = Integer.parseInt(number);
            offsets[reminder]++;
        }
    }
}
