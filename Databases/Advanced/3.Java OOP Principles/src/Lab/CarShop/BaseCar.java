package Lab.CarShop;
public abstract class BaseCar implements Car{
    private String model;
    private String color;
    private int horsePower;

    public String getCountryProduced() {
        return countryProduced;
    }

    private String countryProduced;


    public BaseCar(String model, String color, int horsePower,String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
}
