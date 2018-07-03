package wildFarm;

import wildFarm.engines.Engine;
import wildFarm.core.Controller;
import wildFarm.io.ConsoleInputReader;
import wildFarm.io.ConsoleOutputWriter;
import wildFarm.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        InputParser inputParser = new InputParser();
        Controller controller = new Controller();
        Engine engine = new Engine(inputReader, inputParser, controller);

        engine.run();
    }
}
