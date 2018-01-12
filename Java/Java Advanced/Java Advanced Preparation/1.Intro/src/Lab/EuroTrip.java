package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class EuroTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double quantity = Double.parseDouble(br.readLine());
        Double pricePerKg = 1.20;

        BigDecimal priceInBgn = new BigDecimal(pricePerKg*quantity);
        BigDecimal result = new BigDecimal("4210500000000");

        result = result.multiply(priceInBgn);
        System.out.printf("%.2f marks", result);
    }
}
