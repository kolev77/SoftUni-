package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        try {
            readTrainers(br, trainers);
            playTournament(br, trainers);
            trainers.values().forEach(t -> t.setPokemons(t.getPokemons().stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList())));
            trainers.values().stream().sorted((x,y)-> Integer.compare(y.getBadges(),x.getBadges())).forEach(t -> System.out.printf("%s %d %d\n", t.getName(), t.getBadges(), t.getPokemons().size()));
        } catch ( ArrayIndexOutOfBoundsException ex){

        }

    }

    private static void playTournament(BufferedReader br, HashMap<String, Trainer> trainers) throws IOException {
        String input = br.readLine();
        while (!input.equals("End")) {
            int counter = 0;
            if (input.equals("Fire")) {
                for (Trainer trainer : trainers.values()) {
                    int count = ((int) trainer.getPokemons().stream().filter(p -> p.getElement().equals("Fire")).count());
                    if (count > 0) {
                        trainer.setBadges(trainer.getBadges() + count);
                    } else {
                        trainer.getPokemons().stream().forEach(p-> p.setHealth(p.getHealth()-10));
                    }
                }
            } else if (input.equals("Water")) {
                for (Trainer trainer : trainers.values()) {
                    int count = ((int) trainer.getPokemons().stream().filter(p -> p.getElement().equals("Water")).count());
                    if (count > 0) {
                        trainer.setBadges(trainer.getBadges() + count);
                    } else {
                        trainer.getPokemons().stream().forEach(p-> p.setHealth(p.getHealth()-10));
                    }
                }
            } else if (input.equals("Electricity")) {
                for (Trainer trainer : trainers.values()) {
                    int count = ((int) trainer.getPokemons().stream().filter(p -> p.getElement().equals("Electricity")).count());
                    if (count > 0) {
                        trainer.setBadges(trainer.getBadges() + count);
                    } else {
                        trainer.getPokemons().stream().forEach(p-> p.setHealth(p.getHealth()-10));
                    }
                }
            }
            input = br.readLine();
        }
    }

    private static void readTrainers(BufferedReader br, HashMap<String, Trainer> trainers) throws IOException {
        String[] input = br.readLine().split("\\s+");
        while (!input[0].equals("Tournament")) {
            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            Integer pokemonHealth = Integer.valueOf(input[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainers.containsKey(trainerName)) {
                trainers.get(trainerName).getPokemons().add(pokemon);
            } else {
                Trainer trainer = new Trainer(trainerName);
                trainer.getPokemons().add(pokemon);
                trainers.put(trainerName, trainer);
            }
            input = br.readLine().split("\\s+");
        }
    }
}
