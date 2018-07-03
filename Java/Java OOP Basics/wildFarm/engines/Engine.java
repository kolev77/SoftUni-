package wildFarm.engines;

import wildFarm.core.Controller;
import wildFarm.io.ConsoleInputReader;
import wildFarm.utilities.Constants;
import wildFarm.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private InputParser inputParser;
    private Controller controller;

    public Engine(ConsoleInputReader inputReader, InputParser inputParser, Controller controller) {
        this.inputReader = inputReader;
        this.inputParser = inputParser;
        this.controller = controller;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            if (inputLine.equalsIgnoreCase(Constants.INPUT_TERMINATING_COMMAND)) {
                this.controller.quit();
                break;
            }

            this.dispatchCommandAnimal(commandParams);

            inputLine = this.inputReader.readLine();
            commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommandFood(commandParams);
            this.controller.makeSound();
            this.controller.feedAnimal();
        }
    }

    private void dispatchCommandAnimal(List<String> commandParams) {
        String command = commandParams.get(0); //animal type
        String animalName = commandParams.get(1);
        double animalWeight = Double.parseDouble(commandParams.get(2));
        String livingRegion = commandParams.get(3);
        String catBreed;

        switch (command.toLowerCase()) {
            case "mouse":
                controller.createMouse(animalName, command, animalWeight, livingRegion);
                break;
            case "cat":
                catBreed = commandParams.get(4);
                controller.createCat(animalName, command, animalWeight, livingRegion, catBreed);
                break;
            case "tiger":
                controller.createTiger(animalName, command, animalWeight, livingRegion);
                break;
            case "zebra":
                controller.createZebra(animalName, command, animalWeight, livingRegion);
                break;
            case "end":
                break;
        }
    }

    private void dispatchCommandFood(List<String> commandParams) {
        String command = commandParams.get(0); //food type
        int quantity = Integer.parseInt(commandParams.get(1));

        switch (command.toLowerCase()) {
            case "meat":
                controller.createMeat(quantity);
                break;
            case "vegetable":
                controller.createVegetable(quantity);
                break;
        }
    }
}
