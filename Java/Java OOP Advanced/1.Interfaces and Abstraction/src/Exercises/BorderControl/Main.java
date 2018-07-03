package Exercises.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> identifiables = new ArrayList<>();

        String[] input = br.readLine().split("\\s+");

        while (!input[0].equalsIgnoreCase("end")) {
            if (input.length == 3) {
                Citizen citizen = new Citizen(input[0], Integer.valueOf(input[1]), input[2]);
                identifiables.add(citizen);
            } else {
                Robot robot = new Robot(input[0], input[1]);
                identifiables.add(robot);
            }
            input = br.readLine().split("\\s+");
        }
        String fakeRegex = br.readLine();

        identifiables.stream().filter(i-> i.getId().endsWith(fakeRegex)).forEach(i-> System.out.println(i.getId()));

    }

}
