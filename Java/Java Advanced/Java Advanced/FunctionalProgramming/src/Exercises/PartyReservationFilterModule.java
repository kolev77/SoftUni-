package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNames = br.readLine().split(" ");
        List<String> names = Arrays.asList(inputNames);
        String command = br.readLine();


        while (!"Print".equals(command)) {
            String[] input = command.split(";");
            String action = input[0];
            String condition = input[1];
            String parameter = input[2];
            if ("Add filter".equals(action)) {
                Predicate<String> filter = buildPredicateAddFilter(condition, parameter);
                names = names.stream().filter(filter).collect(Collectors.toList());
            } else if ("Remove filter".equals(action)) {
                List<String> currentNames = Arrays.asList(inputNames);
                Predicate<String> filter = buildPredicateRemoveFilter(condition, parameter);
                currentNames = currentNames.stream().filter(filter).collect(Collectors.toList());
                for (String currentName : currentNames) {
                    names.add(currentName);
                }
            }
            command = br.readLine();
        }
        names.stream().sorted((a,b)-> b.compareTo(a)).forEach(x -> System.out.print(x+ " "));

    }

    public static Predicate<String> buildPredicateAddFilter(String command, String variable) {
        switch (command) {
            case "Starts with":
                return x -> !x.startsWith(variable);
            case "Ends with":
                return x -> !x.endsWith(variable);
            case "Length":
                return x -> x.length() != Integer.valueOf(variable);
            case "Contains":
                return x -> !x.contains(variable);
            default:
                return null;
        }
    }

    public static Predicate<String> buildPredicateRemoveFilter(String command, String variable) {
        switch (command) {
            case "Starts with":
                return x -> x.startsWith(variable);
            case "Ends with":
                return x -> x.endsWith(variable);
            case "Length":
                return x -> x.length() == Integer.valueOf(variable);
            case "Contains":
                return x -> x.contains(variable);
            default:
                return null;
        }
    }
}