package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split("\\s+");
        Double result = 0.0;
        for (int i = 0; i < numbers.length; i++) {
            String[] data = numbers[i].split("");
            Character firstLetter = data[0].charAt(0);
            int number = Integer.valueOf(numbers[i].substring(numbers[i].indexOf(firstLetter) + 1, numbers[i].length() - 1));
            Character secondLetter = data[data.length - 1].toCharArray()[0];
            double sum = 0;
            if (Character.isUpperCase(firstLetter)) {
                firstLetter = firstLetter.toString().toLowerCase().charAt(0);
                sum = (double) number / (double) posInAlphabet(firstLetter);
            } else {
                sum = (double) number * (double) posInAlphabet(firstLetter);
            }

            if (Character.isUpperCase(secondLetter)) {
                secondLetter = secondLetter.toString().toLowerCase().charAt(0);

                sum -= (double) posInAlphabet(secondLetter);
            } else {
                sum += (double) posInAlphabet(secondLetter);
            }
            result += sum;
        }
        System.out.printf("%.2f", result);
    }

    public static int posInAlphabet(char c) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int pos = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                pos = i + 1;
                continue;
            }
        }
        return pos;
    }
}