package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = br.readLine().split(" ");
        Consumer<String> cons = x -> System.out.println("Sir "+x);
        for (int i = 0; i < names.length; i++) {
            cons.accept(names[i]);
        }
    }
}
