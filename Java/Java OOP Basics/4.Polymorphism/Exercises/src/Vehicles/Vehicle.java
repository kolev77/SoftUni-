package Vehicles;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    Double getFuelQuantity() {
        return fuelQuantity;
    }

    Double getFuelConsumption() {
        return fuelConsumption;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double fuelQuantity);
}
