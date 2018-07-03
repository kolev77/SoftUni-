package wildFarm.entities.Animal;

import wildFarm.entities.Food.Food;
import wildFarm.utilities.Constants;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public void setLivingRegion(String livingRegion) {
        super.setLivingRegion(livingRegion);
    }

    @Override
    public String makeSound() {
        return Constants.DEFAULT_TIGER_SOUND;
    }

    @Override
    public void eat(Food food) {
        String foodType = food.getClass().getSimpleName();
        if (!"Meat".equalsIgnoreCase(foodType)) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }
}
