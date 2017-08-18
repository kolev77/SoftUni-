package Lab.CarShop;

public final class Audi extends BaseCar implements Rentable {

    private final int minRentDay;
    private final double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }


    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
}
