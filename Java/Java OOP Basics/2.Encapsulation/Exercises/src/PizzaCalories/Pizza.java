package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private List<Topping> toppings;
    private Dough dough;
    private int toppingsCount;

    public Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.toppings = new ArrayList<>();
        this.setToppingsCount(toppingsCount);
    }

    public Double getAllCalories() {
        Double toppingsCalories = this.toppings.stream().mapToDouble(Topping::getCalories).sum();
        Double doughCalories = this.dough.getCalories();
        return toppingsCalories + doughCalories;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public String getName() {
        return name;
    }

    public int getToppingsCount() {
        return toppings.size();
    }

    private void setName(String name) {
        if (name == null || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppingsCount(int toppingsCount) {
        if (toppingsCount < 0 || toppingsCount > 10) {
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount = toppingsCount;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f",this.getName(),this.getAllCalories());
    }
}
