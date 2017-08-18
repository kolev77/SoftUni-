package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Rostislav Kolev on 08-Jul-17.
 */
public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> full_names = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            if (data[0].compareTo(data[1]) < 0) {
                full_names.add(data);
            }
            input = br.readLine();
        }
        full_names.stream().forEach(x -> System.out.println(x[0] + " " + x[1]));
    }
}
