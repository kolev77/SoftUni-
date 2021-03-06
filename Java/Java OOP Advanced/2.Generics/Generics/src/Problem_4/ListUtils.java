package Problem_4;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty.");
        }
        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty.");
        }
        T min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static List<Integer> getNullIndices(List<?> list) {
        List<Integer> nulls = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                nulls.add(i);
            }
        }
        return nulls;
    }

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> src) {
        for (List<? extends T> inner : src) {
            dest.addAll(inner);
        }

    }

    public static <T> void addAll(List<? super T> dest, List<? extends T> source) {
        for (T element : source) {
            dest.add(element);
        }
    }


    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 4, 5, 6);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 2.2, 3.4, 45d);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> resultNumbers = new ArrayList<>();
        ListUtils.flatten(resultNumbers, jagged);

        System.out.println(resultNumbers);


//        System.out.println(ListUtils.getNullIndices(ints));
//        System.out.println(ListUtils.getMax(ints));
//        System.out.println(ListUtils.getMin(ints));
    }
}
