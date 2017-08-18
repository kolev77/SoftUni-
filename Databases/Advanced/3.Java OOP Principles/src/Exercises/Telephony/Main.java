package Exercises.Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        String[] sites = br.readLine().split(" ");

        SmartPhone phone = new SmartPhone();

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(phone.call(numbers[i]));
        }

        for (int i = 0; i < sites.length; i++) {
            System.out.println(phone.browse(sites[i]));
        }
    }
}
