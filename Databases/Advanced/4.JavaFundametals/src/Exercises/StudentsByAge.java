package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String[]> students = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            students.add(data);
            input = br.readLine();
        }

        students.stream()
                .filter(x -> Integer.valueOf(x[2]) >= 18 && Integer.valueOf(x[2]) <= 24)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));

    }


}
