package NeedForSpeed.models.cars;

public class ShowCar extends Car {
    private final int DEFAULT_STARS = 0;
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.stars = DEFAULT_STARS;
    }

    public int getStars() {
        int stars = this.stars;
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\n%d *", getStars());
    }
}
