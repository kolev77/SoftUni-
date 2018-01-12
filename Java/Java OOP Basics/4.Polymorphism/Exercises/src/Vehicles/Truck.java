package Vehicles;

public class Truck extends Vehicle {
    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public void drive(double distance) {
        Double neededFuel = distance * super.getFuelConsumption();
        if (neededFuel <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - neededFuel);
        } else {
            throw new IllegalStateException("Truck needs refueling");
        }
    }

    @Override
    public void refuel(double fuelQuantity) {
        this.setFuelQuantity(this.getFuelQuantity() + fuelQuantity * 0.95);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
