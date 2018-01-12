package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransportPrice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer distance = Integer.parseInt(br.readLine());
        String time = br.readLine();
        Double price = 0d;

        if (distance < 20) {  // taxi
            price += 0.70;
            if (time.equals("day")) {
                price += distance * 0.79;
            } else if (time.equals("night")) {
                price += distance * 0.90;
            }
        } else if (distance < 100) {  // bus
            price = distance * 0.09;

        } else {   // train
            price = distance * 0.06;
        }
        System.out.printf("%.2f", price);

    }
}
