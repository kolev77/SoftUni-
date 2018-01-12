package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    public T getRandomElement() {
        int index = random.nextInt(super.size());
        T element = super.get(index);
        super.set(index, super.get(super.size() - 1));
        this.remove(super.size() - 1);

        return element;
    }
}
