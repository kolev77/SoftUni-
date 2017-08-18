package Lab.CarShop;

public class Seat extends BaseCar implements Sellable {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private Double price;

    public Seat(String model, String color, int horsePower, String countryProduced,double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public String toString() {
        return "This is " + super.getModel() + " produced in " + super.getCountryProduced() +
                " and have " + TIRES + " tires.";
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
