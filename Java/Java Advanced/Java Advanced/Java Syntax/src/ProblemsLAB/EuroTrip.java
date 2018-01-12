package ProblemsLAB;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Rostislav Kolev on 16-Jan-17.
 */
public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = Double.parseDouble(scanner.nextLine());

        double pricePerKg = 1.20;
        BigDecimal priceInBGN = new BigDecimal(pricePerKg * quantity);

        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal marksNeeded = exchangeRate.multiply(priceInBGN);

        System.out.printf("%.2f marks", marksNeeded);

    }
}
