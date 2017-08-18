package Exercises.IntersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by Rostislav Kolev on 04-Jul-17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input1 = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] input2 = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Circle c1 = new Circle(new Point(input1[0], input1[1]), input1[2]);
        Circle c2 = new Circle(new Point(input2[0], input2[1]), input2[2]);

       boolean isIntersected =  intersect(c1, c2);

        if (isIntersected)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean intersect(Circle c1, Circle c2) {
        Point a = c1.getCenter();
        Point b = c2.getCenter();
        Double distance = Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow(a.getY() - b.getY(), 2));

        if (distance <= c1.getRadius() + c2.getRadius()) {
            return true;
        }
        return false;
    }
}

