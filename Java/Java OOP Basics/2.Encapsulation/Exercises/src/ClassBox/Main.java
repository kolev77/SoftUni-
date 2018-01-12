package ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.valueOf(br.readLine());
        double width= Double.valueOf(br.readLine());
        double height = Double.valueOf(br.readLine());
        Box box = new Box(length,width,height);
        System.out.println(box);
    }
}
