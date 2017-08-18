package Exercises.IntersectionOfCircles;

/**
 * Created by Rostislav Kolev on 04-Jul-17.
 */
public class Circle {
    Point center;
    Integer radius;

    public Circle(Point center, Integer radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Integer getRadius() {
        return this.radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

}
