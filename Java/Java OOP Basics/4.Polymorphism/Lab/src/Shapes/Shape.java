package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Shape() {
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    public abstract void calculatePerimeter();
    public abstract void calculateArea();

}
