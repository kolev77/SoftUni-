package wildFarm.entities.Animal;

import wildFarm.entities.Food.Food;
import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    String getLivingRegion() {
        return this.livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String makeSound() {
        return null;
    }

    @Override
    public void eat(Food food) {

    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(),
                df.format(super.getAnimalWeight()), this.getLivingRegion(), super.getFoodEaten());
    }
}
