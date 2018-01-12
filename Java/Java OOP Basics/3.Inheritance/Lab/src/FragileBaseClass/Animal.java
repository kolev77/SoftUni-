package FragileBaseClass;

import java.util.ArrayList;
import java.util.Arrays;

public class Animal {
    protected ArrayList<Food> foodEaten;

    public final void eat(Food food) {
        foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        Arrays.stream(foods).forEach(f -> foodEaten.add(f));
    }
}
