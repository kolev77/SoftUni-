package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class ProductOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Integer n = Integer.valueOf(input[0]);
        Integer m = Integer.valueOf(input[1]);
        BigDecimal result = new BigDecimal(n);

        for (int i = n+1; i <= m; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }

        System.out.printf("product[%d..%d] = %.0f",n,m,result);
    }
}
