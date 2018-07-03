package wildFarm.entities.Animal;

import wildFarm.entities.Food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    String getAnimalName() {
        return this.animalName;
    }

    String getAnimalType() {
        return this.animalType;
    }

    double getAnimalWeight() {
        return this.animalWeight;
    }

    int getFoodEaten() {
        return this.foodEaten;
    }

    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract String makeSound();

    public abstract void eat(Food food);
}
