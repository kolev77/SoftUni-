package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rostislav Kolev on 09-Jul-17.
 */
public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, List<String>> groupes = new HashMap<>();
        String input = br.readLine();
        while (!input.equals("END")) {
            String[] data = input.split(" ");
            String name = data[0] + " " + data[1];
            Integer group = Integer.valueOf(data[2]);
            if (groupes.containsKey(group)) {
                List<String> current = groupes.get(group);
                current.add(name);
                groupes.put(group, current);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(name);
                groupes.put(group, newList);
            }
            input = br.readLine();
        }

        groupes.keySet().stream().
                forEach(x -> System.out.println
                        (x + " - " + String.join(", ", groupes.get(x))));
    }
}