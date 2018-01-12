package Exercises;

import java.util.Scanner;

public class TerroristWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] result = input.toCharArray();

        for (int ch = 0; ch < result.length; ch++) {
            if (result[ch] == '|') {
                int bombStart = ch;
                int bombEnd = findBombEnd(result, bombStart + 1);

                String bombStr = extractBombStr(result, bombStart + 1);
                int bombRadius = calcBombRadius(bombStr);

                bombStart -= bombRadius;
                bombEnd += bombRadius;

                if (bombStart < 0) bombStart = 0;
                if (bombEnd >= result.length) bombEnd = result.length - 1;

                result = bombResult(result, bombStart, bombEnd);
            }
        }
        System.out.println(result);
    }

    private static char[] bombResult(char[] target, int start, int end) {
        for (int i = start; i <= end; i++) {
            target[i] = '.';
        }
        return target;
    }

    private static int calcBombRadius(String bombStr) {
        char[] chars = bombStr.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c;
        }
        return sum % 10;
    }

    private static String extractBombStr(char[] target, int start) {
        String bombStr = "";
        for (int i = start; i < target.length; i++) {
            if (target[i] == '|') break;
            bombStr += target[i];
        }
        return bombStr;
    }

    private static int findBombEnd(char[] target, int bombStart) {
        int end = 0;
        for (int i = bombStart; i < target.length; i++) {
            if (target[i] == '|') {
                end = i;
                break;
            }
        }
        return end;
    }
}