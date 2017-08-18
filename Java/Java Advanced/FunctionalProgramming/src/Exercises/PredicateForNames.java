package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = Integer.valueOf(br.readLine());
        String[] names = br.readLine().split(" ");
        Predicate<String> condition = x -> x.length() <= maxLength;
        for (int i = 0; i < names.length; i++) {
            if (condition.test(names[i])){
                System.out.println(names[i]);
            }
        }
    }
}
