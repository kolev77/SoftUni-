package WildFarm.animals;

import WildFarm.foods.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, double animalWeight, int foodEaten) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = foodEaten;
    }

    protected void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected double getAnimalWeight() {
        return animalWeight;
    }

    protected int getFoodEaten() {
        return foodEaten;
    }

    public abstract String makeSound();

    public abstract void eat(Food food, int foodQuantity);
}
