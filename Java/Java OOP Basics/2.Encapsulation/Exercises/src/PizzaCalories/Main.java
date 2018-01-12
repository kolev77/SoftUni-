package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        if (input[0].equals("Pizza")) {
            try {
                Pizza pizza = new Pizza(input[1], Integer.valueOf(input[2]));
                input = reader.readLine().split(" ");
                while (!"END".equals(input[0])) {
                    if ("Dough".equals(input[0])) {
                        try {
                            Dough dough = new Dough(input[1].toLowerCase(), input[2].toLowerCase(), Double.valueOf(input[3]));
                            pizza.setDough(dough);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                            return;
                        }
                    } else if ("Topping".equals(input[0])) {
                        try {
                            Topping topping = new Topping(input[1], Double.valueOf(input[2]));
                            pizza.addTopping(topping);

                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                            return;
                        }
                    }

                    input = reader.readLine().split(" ");
                }
                System.out.println(pizza);
            } catch (IllegalStateException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}