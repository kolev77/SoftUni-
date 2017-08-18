package Exercises.LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 04-Jul-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Number number = new Number();
        number.setValue((Integer.valueOf(br.readLine()))%10);
        System.out.println(number.getNameOfLastDigit());
    }
}
