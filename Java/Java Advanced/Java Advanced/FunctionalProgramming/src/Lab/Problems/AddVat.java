package Lab.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(", ");
        List<Double> numbers = new ArrayList<>();

        for (String s : input) {
            numbers.add(Double.parseDouble(s));
        }
        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (Double number : numbers) {
            String num = String.format("%1$.2f", addVat.apply(number));
            System.out.println(num.replace('.',','));
        }
    }
}
