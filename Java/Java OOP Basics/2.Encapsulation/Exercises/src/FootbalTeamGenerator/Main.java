package FootbalTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(";");
        HashMap<String, Team> teams = new HashMap<>();

        while (!"END".equals(input[0])) {
            switch (input[0].toLowerCase()) {
                case "team":
                    try {
                        Team team = new Team(input[1]);
                        teams.put(input[1], team);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;

                case "add":
                    String teamName = input[1];
                    String playerName = input[2];
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.", teamName);
                        return;
                    }
                    try {
                        Player player = new Player(playerName, Integer.valueOf(input[3]), Integer.valueOf(input[4]), Integer.valueOf(input[5]), Integer.valueOf(input[6]), Integer.valueOf(input[7]));
                        teams.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;


                case "remove":
                    String tName = input[1];
                    String pName = input[2];

                    if (!teams.containsKey(tName)) {
                        System.out.printf("Team %s does not exist.", tName);
                        break;
                    }
                    try {
                        teams.get(tName).removePlayer(pName);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;

                case "rating":
                    if (!teams.containsKey(input[1])) {
                        System.out.println(String.format("Team %s does not exist.", input[1]));
                        break;
                    }
                    System.out.println(teams.get(input[1]));
                    break;
            }
            input = br.readLine().split(";");
        }
    }
}
