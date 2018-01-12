package Lab.Problems;

import java.util.Arrays;
import java.util.Scanner;

public class ReadSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        Arrays.sort(names);

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

}
