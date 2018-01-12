package WildFarm.animals;

import WildFarm.foods.Food;

import java.text.DecimalFormat;


public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food, int foodQuantity) {
        this.setFoodEaten(foodQuantity);
    }

    private String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(),this.getBreed(), new DecimalFormat("#.##").format(super.getAnimalWeight()),
                super.getLivingRegion(), super.getFoodEaten());
    }
}
