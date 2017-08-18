package Lab.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(", ");
            String name = input[0];
            Integer age = Integer.valueOf(input[1]);
            people.put(name, age);
        }
        boolean getBiggerAge = false;
        switch (br.readLine()) {
            case "older":
                getBiggerAge = true;
                break;
            case "younger":
                getBiggerAge = false;
                break;
        }
        int target = Integer.valueOf(br.readLine());
        String[] attr = br.readLine().split(" ");

        boolean finalGetBiggerAge = getBiggerAge;
        people.entrySet().stream().filter(p -> {
            if (finalGetBiggerAge) {
                return p.getValue() >= target;
            } else {
                return p.getValue() < target;
            }
        }).forEach(p -> {
            if (attr.length == 1) {
                if (attr[0].equalsIgnoreCase("name")) {
                    System.out.printf("%s\n", p.getKey());

                } else {
                    System.out.printf("%s\n", p.getValue());

                }
            } else {
                System.out.printf("%s - %s\n", p.getKey(), p.getValue());
            }
        });
    }
}
