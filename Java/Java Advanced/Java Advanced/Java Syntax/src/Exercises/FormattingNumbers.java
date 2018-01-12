package Exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        float b = input.nextFloat();
        float c = input.nextFloat();
        String stringB = String.format("%.2f", b);
        String stringC = String.format("%.3f", c);

        System.out.print("|" + Integer.toHexString(a).toUpperCase() + AddPadding(Integer.toHexString(a).toUpperCase(), ' ') + "|");
        System.out.print(AddPadding(Integer.toBinaryString(a), '0') + Integer.toBinaryString(a) + "|");
        System.out.printf("%s%s|", AddPadding(stringB, ' '), stringB);
        System.out.printf("%s%s|", stringC, AddPadding(stringC, ' '));
    }

    public static String AddPadding(String word, char ch) {
        String paddingPart = "";
        for (int i = 0; i < 10 - word.length(); i++) {
            paddingPart += ch;
        }
        return paddingPart;
    }
}
