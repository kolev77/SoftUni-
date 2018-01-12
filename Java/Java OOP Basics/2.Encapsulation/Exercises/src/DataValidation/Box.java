package DataValidation;

public class Box {
    private static final String ERROR_MSG = " cannot be zero or negative.";
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setHeight(height);
        setWidth(width);
    }

    public void setLength(double length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length" + ERROR_MSG);
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width" + ERROR_MSG);
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height < 1) {
            throw new IllegalArgumentException("Height" + ERROR_MSG);
        }
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
        return String.format("Surface Area - %.2f\nLateral Surface Area - %.2f\nVolume - %.2f", this.getSurfaceArea(), this.getLateralSurface(), this.getVolume());
    }
}
