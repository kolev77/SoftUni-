package VehiclesExtension;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;
    private Double tankCapacity;

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else
            this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected Double getFuelQuantity() {
        return fuelQuantity;
    }

    protected Double getFuelConsumption() {
        return fuelConsumption;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public abstract void drive(double distance);

    public void driveEmpty(double distance) {
    }

    public void refuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if (this.getFuelQuantity() + fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += fuelQuantity;
        }
    }
}
