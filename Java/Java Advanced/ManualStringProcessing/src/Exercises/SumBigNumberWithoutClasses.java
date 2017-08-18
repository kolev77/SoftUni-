package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumberWithoutClasses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder first = new StringBuilder(br.readLine());
        StringBuilder second = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        int overflow = 0;

        removeZeros(first);
        removeZeros(second);

        first.reverse();
        second.reverse();

        if (second.length() > first.length()) {
            for (int i = 0; i < first.length(); i++) {
                int tempFirst = Integer.valueOf(first.substring(i, i + 1));
                int tempSecond = Integer.valueOf(second.substring(i, i + 1));
                int sum = tempSecond + tempFirst + overflow;

                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;
                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }

            for (int i = first.length(); i < second.length(); i++) {
                int tempSecond = Integer.parseInt(second.substring(i, i + 1));
                int sum = tempSecond + overflow;
                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;
                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }
        } else {
            for (int i = 0; i < second.length(); i++) {
                int tempFirst = Integer.valueOf(first.substring(i, i + 1));
                int tempSecond = Integer.valueOf(second.substring(i, i + 1));
                int sum = tempSecond + tempFirst + overflow;

                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;
                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }
            for (int i = second.length(); i < first.length(); i++) {
                int tempFirst = Integer.parseInt(first.substring(i, i + 1));
                int sum = tempFirst + overflow;
                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;
                } else {
                    overflow = 0;
                }

                result.insert(0, sum);
            }
            if (overflow > 0) {
                result.insert(0, overflow);
            }
        }
        System.out.println(result);
    }

    private static void removeZeros(StringBuilder num) {
        while (num.charAt(0) == '0') {
            num.delete(0, 1);
        }

    }
}
