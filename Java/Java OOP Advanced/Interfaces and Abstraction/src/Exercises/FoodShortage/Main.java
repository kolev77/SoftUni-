package Exercises.FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.valueOf(br.readLine());
        List<Buyer> buyers = new ArrayList<>();
        int food = 0;

        addBuyers(br, numberOfPeople, buyers);
        buyFood(br, buyers);
        printFoodPurchased(buyers, food);
    }

    private static void printFoodPurchased(List<Buyer> buyers, int food) {
        for (Buyer buyer : buyers) {
            food += buyer.getFood();
        }
        System.out.println(food);
    }

    private static void addBuyers(BufferedReader br, int numberOfPeople, List<Buyer> buyers) throws IOException {
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = br.readLine().split("\\s+");
            if (input.length == 3) {
                Buyer buyer = new Rebel(input[0], Integer.valueOf(input[1]), input[2]);

                if (buyers.stream().filter(b -> b.getName().equalsIgnoreCase(input[0])).count() == 0) {
                    buyers.add(buyer);
                }
            } else if (input.length == 4) {
                Buyer buyer = new Citizen(input[0], Integer.valueOf(input[1]), input[2], input[3]);
                if (buyers.stream().filter(b -> b.getName().equalsIgnoreCase(input[0])).count() == 0) {
                    buyers.add(buyer);
                }
            }
        }
    }

    private static void buyFood(BufferedReader br, List<Buyer> buyers) throws IOException {
        String input = br.readLine();
        while (!input.equalsIgnoreCase("end")) {
            String name = input;
            List<Buyer> buyers1 =  buyers.stream().filter(b -> b.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
            if (!buyers1.isEmpty())
                buyers1.get(0).buyFood();
            input = br.readLine();
        }
    }

}
