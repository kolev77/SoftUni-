package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractBitFromInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer n = Integer.valueOf(input[0]);
        Integer p = Integer.valueOf(input[1]);
        String binary = Integer.toBinaryString(n);

        if (binary.length() < p) {
            System.out.println(0);
        } else
            System.out.println(binary.charAt(binary.length()-1 - p));

    }
}
