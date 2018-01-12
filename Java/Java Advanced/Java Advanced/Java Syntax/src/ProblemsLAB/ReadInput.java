package ProblemsLAB;

import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
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
