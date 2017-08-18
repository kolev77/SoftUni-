package Exercises.ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Rostislav Kolev on 04-Jul-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] persons_array = br.readLine().split(";");
        String[] products_array = br.readLine().split(";");
        LinkedHashMap<String, Person> clients = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();
        readPersons(persons_array, clients);
        readProducts(products_array, products);

        String input = br.readLine();
        if (!clients.isEmpty()) {
            while (!input.equals("END")) {
                Person client = clients.get(input.split(" ")[0]);
                Product product = products.get(input.split(" ")[1]);


                if (client.getMoney() >= product.getCost()) {
                    client.setMoney(client.getMoney() - product.getCost());
                    System.out.printf("%s bought %s", client.getName(), product.getName());
                    System.out.println();

                    if (client.getBag().isEmpty()) {
                        ArrayList<Product> bag = new ArrayList<>();
                        bag.add(product);
                        client.setBag(bag);
                    } else {
                        List<Product> bag = client.getBag();
                        bag.add(product);
                        client.setBag(bag);
                    }
                } else {
                    System.out.printf("%s can't afford %s", client.getName(), product.getName());
                    System.out.println();
                }
                input = br.readLine();
            }

            for (String client : clients.keySet()) {
                Person person = clients.get(client);

                List<Product> bag = person.getBag();
                if (!bag.isEmpty()) {
                    System.out.print(client + " - ");
                    for (int i = 0; i < bag.size(); i++) {
                        if (i < bag.size() - 1) {
                            System.out.print(bag.get(i).getName() + ", ");
                        } else
                            System.out.print(bag.get(i).getName());
                    }
                    System.out.println();

                } else {
                    System.out.println(person.getName() + " - Notning bought");
                }
            }
        }
    }

    private static void readProducts(String[] products_array, HashMap<String, Product> products) {
        for (int i = 0; i < products_array.length; i++) {
            String[] product_n_cost = products_array[i].split("=");
            String name = product_n_cost[0];
            Double money = Double.valueOf(product_n_cost[1]);
            Product current = new Product();
            current.setName(name);
            current.setCost(money);
            products.put(current.getName(), current);
        }
    }

    public static void readPersons(String[] persons, HashMap<String, Person> clients) {
        for (int i = 0; i < persons.length; i++) {
            String[] personAndMoney = persons[i].split("=");
            String name = personAndMoney[0];
            Double money = Double.valueOf(personAndMoney[1]);
            Person current = new Person();
            current.setName(name);
            if (money >= 0) {
                current.setMoney(money);
                current.setBag(new ArrayList<Product>());
                clients.put(current.getName(), current);
            }else
                System.out.println("Money cannot be negative");

        }
    }
}
