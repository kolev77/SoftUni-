package ProblemsLAB;

import java.util.Scanner;

public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double width = input.nextDouble();
        double height = input.nextDouble();
        double area = Area(width, height);
        System.out.printf("Area = %.2f", area);

    }

    static double Area(double width, double height){
        return (width*height)/2;
    }
}
