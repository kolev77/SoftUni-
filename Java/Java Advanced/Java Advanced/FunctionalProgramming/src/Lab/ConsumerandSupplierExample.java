package Lab;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerandSupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> dice = () -> ThreadLocalRandom.current().nextInt(2, 12);
        Consumer<String> print = message -> System.out.println(message);

        for (int i = 0; i < 4; i++) {
            print.accept(dice.get().toString());
        }
    }
}
