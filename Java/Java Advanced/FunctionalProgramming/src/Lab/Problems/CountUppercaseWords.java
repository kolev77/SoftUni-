package Lab.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);
        int counter = 0;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            if (checkerUpperCase.test(text[i])){
                counter++;
                result.add(text[i]);
            }
        }
        System.out.println(counter);
        result.forEach(x -> System.out.println(x));
    }
}
