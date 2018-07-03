package Problem_2;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(Class<T> cl, int length, T item) {
        T[] array = (T[]) Array.newInstance(cl, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static void main(String[] args) {
        String[] names = ArrayCreator.create(String.class, 5, "Goshi");
        Integer[] numbers = ArrayCreator.create(Integer.class, 5, 10);

        for (String name : names) {
            System.out.println(name);
        }

        for (Integer number : numbers) {
            System.out.println(number);
        }

    }
}
