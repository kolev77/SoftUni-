package repository;

import java.util.ArrayList;
import java.util.List;

public class KittyRepository {
    private List<String> kittens;

    public KittyRepository() {
        kittens = new ArrayList<>();
        kittens.add("Kitty");
        kittens.add("Pesho");
        kittens.add("Gosho");
    }

    public List<String> getKittens() {
        return this.kittens;
    }
}
