package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumberWithoutClasses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder first = new StringBuilder(br.readLine());
        int multiplier = Integer.valueOf(br.readLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }
        int overflow = 0;
        StringBuilder result = new StringBuilder();

        removeZeros(first);
        first.reverse();

        for (int i = 0; i < first.length(); i++) {
            int tempNum = Integer.valueOf(first.substring(i, i + 1));
            int currentResult = (tempNum * multiplier) + overflow;

            if (currentResult > 9) {
                overflow = currentResult / 10;
                currentResult %= 10;
            }else {
                overflow = 0;
            }
            result.insert(0,currentResult);
        }
        if (overflow != 0) {
            result.insert(0,overflow);
        }
        System.out.println(result);
    }
    private static void removeZeros(StringBuilder num) {
        while (num.charAt(0) == '0') {
            num.delete(0, 1);
        }
    }
}
