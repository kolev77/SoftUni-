package softuni.softuni.utilities;

import java.util.Random;

public final class RandomNumber {
    private static Random rnd = new Random();

    private RandomNumber() {}

    public static int getRandomNumber(int bound) {
        return rnd.nextInt(bound);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }
}