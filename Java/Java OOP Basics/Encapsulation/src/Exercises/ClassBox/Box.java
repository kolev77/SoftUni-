package Exercises.ClassBox;

/**
 * Created by Rostislav Kolev on 10-Mar-17.
 */
public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }


    private void setLength(double length) {
        if (length <= 0) {
            throw new NumberFormatException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new NumberFormatException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new NumberFormatException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getSurfaceArea() {
        double area = 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
        return area;
    }

    public double getLateralSurfaceArea() {
        double area = 2 * this.length * this.height + 2 * this.width * this.height;
        return area;
    }

    public double getVolume() {
        double volume = this.length * this.width * this.height;
        return volume;
    }

}
