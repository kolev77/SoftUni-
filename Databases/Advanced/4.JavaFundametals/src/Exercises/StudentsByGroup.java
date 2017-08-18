package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> students = new TreeMap<>();
        String input = br.readLine();
        while (!input.equals("END")){
            String[] data = input.split(" ");
            students.put(data[0]+" "+data[1],Integer.valueOf(data[2]));
            input = br.readLine();
        }
        students.entrySet().stream()
                .filter(x -> x.getValue() == 2)
                .forEach(x-> System.out.println(x.getKey()));
    }
}
