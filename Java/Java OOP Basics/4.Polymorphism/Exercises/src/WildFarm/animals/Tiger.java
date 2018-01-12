package WildFarm.animals;

import WildFarm.foods.Food;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food, int foodQuantity) {
        if (!food.getClass().getSimpleName().equals("Meat")) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(foodQuantity);
    }
}
