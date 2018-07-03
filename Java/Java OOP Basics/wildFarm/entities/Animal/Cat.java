package wildFarm.entities.Animal;

import wildFarm.entities.Food.Food;
import wildFarm.utilities.Constants;
import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return Constants.DEFAULT_CAT_SOUND;
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), this.breed,
                df.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
