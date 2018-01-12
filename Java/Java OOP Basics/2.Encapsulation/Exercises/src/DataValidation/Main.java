package DataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.valueOf(br.readLine());
        double width = Double.valueOf(br.readLine());
        double height = Double.valueOf(br.readLine());
        try {
            Box box = new Box(length, width, height);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
