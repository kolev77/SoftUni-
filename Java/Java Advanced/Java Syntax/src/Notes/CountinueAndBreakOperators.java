package Notes;

import java.util.Scanner;

public class CountinueAndBreakOperators {
    public static void main(String[] args) {

      //  continue bypasses the iteration of the inner-most loop
      //  Example: sum all odd numbers in [1…n], not divisors of 3:

        int n = 100;
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            if (i % 3 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("sum = " + sum);

        //The break operator exits the inner-most loop

            int b = new Scanner(System.in).nextInt();
            // Calculate n! = 1 * 2 * ... * b
            int result = 1;
            while (true) {
                if (b == 1)
                    break;
                result *= b;
                b--;
            }
            System.out.println("b! = " + result);



    }
}
