package Vehicles;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void drive(double distance) {
        double neededFuel = distance * super.getFuelConsumption();
        if (neededFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Car needs refueling");
        } else
            super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
    }

    @Override
    public void refuel(double fuelQuantity) {
        this.setFuelQuantity(this.getFuelQuantity() + fuelQuantity);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
