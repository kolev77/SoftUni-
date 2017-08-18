package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class FromBas10toBaseN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        BigInteger targetBase = new BigInteger(input[0]);
        BigInteger base10 = new BigInteger(input[1]);

        StringBuilder result = new StringBuilder("");
        while (base10.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = base10.divideAndRemainder(new BigInteger(targetBase + ""))[1];
            BigInteger divide = base10.divideAndRemainder(new BigInteger(targetBase + ""))[0];
            result.insert(0, remainder);
            base10 = divide;
        }

        System.out.println(result);
    }
}
