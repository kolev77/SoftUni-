
import sun.swing.StringUIClientPropertyKey;

import java.lang.Object.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.length() < 20) {
            System.out.print(input);
            for (int i = input.length(); i < 20; i++) {
                System.out.print("*");
            }
        } else if (input.length() > 20) {
            System.out.println(input.substring(0, 20));
        }
    }
}
