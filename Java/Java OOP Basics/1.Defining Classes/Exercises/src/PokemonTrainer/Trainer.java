package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static final int DEFAULT_BADGES  =0;
    private String name;

    private int badges;
    private List<Pokemon> pokemons;


    public Trainer(String name) {
        this.name = name;
        this.badges = DEFAULT_BADGES;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
