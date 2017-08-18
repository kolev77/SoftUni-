package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FromBaseNToBase10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        BigInteger numBase = new BigInteger(input[0]);
        BigInteger numBaseN = new BigInteger(input[1]);

        StringBuilder numDigits = new StringBuilder(input[1]).reverse();

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < input[1].length(); i++) {
            BigInteger currentDigit = new BigInteger(input[1].charAt(i) + "");
            BigInteger res = currentDigit.multiply(numBase.pow(input[1].length() - 1 - i));
            result = result.add(res);
        }

        System.out.println(result.toString());
    }
}