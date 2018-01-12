package VehiclesExtension;

public class Car extends Vehicle {

    public Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity,fuelConsumption+0.9,tankCapacity);
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
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
