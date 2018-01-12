package VehiclesExtension;

public class Truck extends Vehicle {
    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption+1.6, tankCapacity);
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
        super.refuel(0.95*fuelQuantity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
