package Lab.DrawCircleAndRectangle;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class Rectangle implements Drawable {
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int width;
    private int height;


    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.print("*");
            for (int k = 1; k < width - 1; k++) {
                System.out.print(" ");
                if (i == 0 || i == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            System.out.print("*");   System.out.print("\n");
        }
    }

}



