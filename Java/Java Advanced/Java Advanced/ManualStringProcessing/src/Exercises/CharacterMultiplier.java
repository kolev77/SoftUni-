package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        String first = data[0];
        String seconds = data[1];
        int sum = 0;

        if (first.length() > seconds.length()) {
            for (int i = 0; i < seconds.length(); i++) {
                sum += Integer.valueOf(first.charAt(i)) * Integer.valueOf(seconds.charAt(i));
            }
            for (int i = seconds.length(); i < first.length(); i++) {
                sum += Integer.valueOf(first.charAt(i));
            }
        } else {
            for (int i = 0; i < first.length(); i++) {
                sum += Integer.valueOf(first.charAt(i)) * Integer.valueOf(seconds.charAt(i));
            }
            for (int i = first.length(); i < seconds.length(); i++) {
                sum += Integer.valueOf(seconds.charAt(i));
            }
        }

        System.out.println(sum);
    }
}
