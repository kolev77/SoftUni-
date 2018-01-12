package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceArea() {
        Double area = Double.valueOf(2 * length * width + 2 * length * height + 2 * width * height);
        return area;
    }


    public double getVolume() {
        Double volume = Double.valueOf(height * length * width);
        return volume;
    }

    public double getLateralSurface() {
        Double area = Double.valueOf(2 * length * height + 2 * width * height);
        return area;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\nLateral Surface Area - %.2f\nVolume - %.2f",this.getSurfaceArea(),this.getLateralSurface(),this.getVolume());
    }
}
