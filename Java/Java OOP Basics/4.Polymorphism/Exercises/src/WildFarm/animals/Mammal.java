package WildFarm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(), new DecimalFormat("#.##").format(super.getAnimalWeight()),
                this.getLivingRegion(), super.getFoodEaten());
    }

    protected String getLivingRegion() {
        return livingRegion;
    }
}
