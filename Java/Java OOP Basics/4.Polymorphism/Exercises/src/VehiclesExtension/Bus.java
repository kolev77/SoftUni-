package VehiclesExtension;

public class Bus extends Vehicle {

    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity,fuelConsumption,tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double neededFuel = distance * (super.getFuelConsumption() + 1.4);
        if (neededFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Bus needs refueling");
        } else
            super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
    }

    @Override
    public void driveEmpty(double distance) {
        double neededFuel = distance * super.getFuelConsumption();
        if (neededFuel > super.getFuelQuantity()) {
            throw new IllegalStateException("Bus needs refueling");
        } else
            super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", super.getFuelQuantity());
    }
}
