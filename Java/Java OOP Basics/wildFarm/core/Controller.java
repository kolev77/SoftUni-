package wildFarm.core;

import wildFarm.entities.Animal.*;
import wildFarm.entities.Food.Food;
import wildFarm.entities.Food.Meat;
import wildFarm.entities.Food.Vegetable;
import wildFarm.io.ConsoleOutputWriter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Animal> animals;
    private Food currentFood;
    private ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();

    public Controller() {
        this.setAnimals();
    }

    private void setAnimals() {
        this.animals = new ArrayList<>();
    }

    public void createMouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        Animal mouse = new Mouse(animalName, animalType, animalWeight, livingRegion);
        this.animals.add(mouse);
    }

    public void createCat(String animalName, String animalType, double animalWeight, String livingRegion, String catBreed) {
        Animal cat = new Cat(animalName, animalType, animalWeight, livingRegion, catBreed);
        this.animals.add(cat);
    }

    public void createTiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        Animal tiger = new Tiger(animalName, animalType, animalWeight, livingRegion);
        this.animals.add(tiger);
    }

    public void createZebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        Animal zebra = new Zebra(animalName, animalType, animalWeight, livingRegion);
        this.animals.add(zebra);
    }

    public void createMeat(int quantity) {
        this.currentFood = new Meat(quantity);
    }

    public void createVegetable(int quantity) {
        this.currentFood = new Vegetable(quantity);
    }

    public void feedAnimal() {
        Animal currentAnimal = this.animals.get(this.animals.size() - 1);
        try {
            currentAnimal.eat(this.currentFood);
        } catch (IllegalArgumentException iae) {
            this.outputWriter.writeLine(iae.getMessage());
        }
    }

    public void makeSound() {
        Animal currentAnimal = this.animals.get(this.animals.size() - 1);
        this.outputWriter.writeLine(currentAnimal.makeSound());
    }

    public void quit() {
        for (Animal animal : animals) {
            this.outputWriter.writeLine(animal.toString());
        }
    }
}
