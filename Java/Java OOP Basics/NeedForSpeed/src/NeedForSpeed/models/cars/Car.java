package NeedForSpeed.models.cars;

public abstract class Car {
    private String _brand;
    private String _model;
    private int yearOfProduction;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    public String get_brand() {
        String brand = this._brand;
        return brand;
    }

    public String get_model() {
        String model =_model;
        return model;
    }

    public int getHorsePower() {

        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    protected Car(String _brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        this._brand = _brand;
        this._model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;

    }

    public int getOverallPerformance() {
        return this.horsePower + this.acceleration;
    }

    public int getEnginePerformance() {
        return (this.horsePower / this.acceleration) + (this.suspension + this.durability);
    }

    public int getSuspensionPerformance(){

        return (this.horsePower/this.acceleration) + (this.suspension + this.durability);
    }
    @Override
    public String toString() {
        return String.format("%s %s %d\n%d HP, 100 m/h in %d s\n%d Suspension force, %d Durability",
                this._brand, this._model, this.yearOfProduction, this.horsePower, this.acceleration, this.suspension, this.durability);

    }
}
