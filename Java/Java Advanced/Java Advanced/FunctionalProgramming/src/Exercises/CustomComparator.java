package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.valueOf(x)).toArray();
        ArrayList<Integer> filtered = new ArrayList<>();
        Arrays.stream(numbers).forEach(x-> filtered.add(x));
        Comparator<Integer> myComparator = (n1, n2) -> {
            if ((n1 % 2 == 0) && (n2 % 2 != 0)) {
                return -1;
            }
            if ((n1 % 2 != 0) && (n2 % 2 == 0)) {
                return 1;
            }
            return n1.compareTo(n2);
        };
        filtered.sort(myComparator);
        filtered.forEach(a -> System.out.print(a +" "));

    }
}

