package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadInput {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String firstWord = input.next("\\w+");
        String secondWord = input.next("\\w+");
        int numInt = input.nextInt();
        double numDouble1 = input.nextDouble();
        double numDouble2 = input.nextDouble();
        input.nextLine();
        String thirdWord = input.nextLine();
        double sum = numInt + numDouble1 + numDouble2;

        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " +(int)sum);
    }
}
