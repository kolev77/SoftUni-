package FirstAndReverseTeam;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            try {
                persons.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.valueOf(input[3])));
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        Team team = new Team("Minior");
        persons.forEach(p-> team.addPlayer(p));

        System.out.println("First team have "+ team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have "+ team.getSecondTeam().size() + " players");

    }
}