package wildFarm.entities.Animal;

import wildFarm.entities.Food.Food;
import wildFarm.utilities.Constants;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return Constants.DEFAULT_MOUSE_SOUND;
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();
        if (!"Vegetable".equalsIgnoreCase(foodType)) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }
}
