package Exercises.ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by Rostislav Kolev on 10-Mar-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double length = Double.valueOf(br.readLine());
        Double width = Double.valueOf(br.readLine());
        Double height = Double.valueOf(br.readLine());

        try {
            Box box = new Box(length, width, height);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

        //System.out.printf("Surface Area - %.2f\nLateral Surface Area - %.2f\nVolume - %.2f",box.getSurfaceArea(),box.getLateralSurfaceArea(),box.getVolume());

    }
}