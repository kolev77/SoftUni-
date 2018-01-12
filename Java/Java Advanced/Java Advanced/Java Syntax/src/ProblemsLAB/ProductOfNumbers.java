package ProblemsLAB;

import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        BigInteger product = BigInteger.ONE;

        for (int i = n; i <= m; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("product[%d..%d] = %d\n", n, m, product);
    }
}
