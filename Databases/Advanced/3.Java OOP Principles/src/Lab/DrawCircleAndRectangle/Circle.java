package Lab.DrawCircleAndRectangle;

/**
 * Created by Rostislav Kolev on 06-Jul-17.
 */
public class Circle implements Drawable {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public void draw() {
        double r_in = this.radius - 0.4;
        double r_out = this.radius + 0.4;
        for (double y = this.radius; y >= -this.radius; --y) {
            for (double x = -this.radius; x < r_out; x += 0.5) {
                double value = x * x + y * y;
                if (value >= r_in * r_in && value <= r_out * r_out) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}


