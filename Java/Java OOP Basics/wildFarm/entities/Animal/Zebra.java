package wildFarm.entities.Animal;

import wildFarm.entities.Food.Food;
import wildFarm.utilities.Constants;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return Constants.DEFAULT_ZEBRA_SOUND;
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();
        if (!"Vegetable".equalsIgnoreCase(foodType)) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }
}