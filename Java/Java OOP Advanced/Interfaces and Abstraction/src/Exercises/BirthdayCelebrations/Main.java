package Exercises.BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Natality> creatures = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();

        readInput(br, creatures, robots);
        String inputYear = br.readLine();
        creatures.stream().filter(c -> c.getBirthdate().endsWith(inputYear)).forEach(c -> System.out.println(c.getBirthdate()));

    }

    private static void readInput(BufferedReader br, List<Natality> creatures, List<Robot> robots) throws IOException {
        String[] input = br.readLine().split("\\s+");
        while (!input[0].equalsIgnoreCase("End")) {
            if (input[0].equalsIgnoreCase("citizen")) {
                Citizen citizen = new Citizen(input[1], Integer.valueOf(input[2]), input[3], input[4]);
                creatures.add(citizen);
            } else if (input[0].equalsIgnoreCase("pet")) {
                Pet pet = new Pet(input[1], input[2]);
                creatures.add(pet);
            } else {
                Robot robot = new Robot(input[1], input[2]);
                robots.add(robot);
            }
            input = br.readLine().split("\\s+");
        }
    }

}
