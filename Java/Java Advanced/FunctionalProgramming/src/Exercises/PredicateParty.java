package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<String> names = Arrays.asList(input);

        String command = br.readLine();

        while (!command.equals("Party!")) {
            String[] tokens = command.split(" ");
            Predicate<String> predicate = buildPredicate(tokens[1], tokens[2]);
            if (tokens[0].equals("Remove")) {
                List<String> guests = new ArrayList<>();
                for (String name : names) {
                    if (!predicate.test(name)) {
                        guests.add(name);
                    }
                }
                names = guests;
            } else if (tokens[0].equals("Double")) {
                List<String> guests = new ArrayList<>();
                for (String name : names) {
                    if (predicate.test(name)) {
                        guests.add(name);
                    }
                    guests.add(name);
                }
                names = guests;
            }
            command = br.readLine();
        }
        if (!names.isEmpty()) {
            System.out.println(String.join(", ", names) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    public static Predicate<String> buildPredicate(String command, String variable) {
        switch (command) {
            case "StartsWith":
                return x -> x.startsWith(variable);
            case "EndsWith":
                return x -> x.endsWith(variable);
            case "Length":
                return x -> x.length() == Integer.valueOf(variable);
            default:
                return null;
        }
    }
}
