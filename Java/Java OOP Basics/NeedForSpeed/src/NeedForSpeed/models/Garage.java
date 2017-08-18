package NeedForSpeed.models;

import NeedForSpeed.models.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    protected Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        List<Car> cars = this.parkedCars;
        return cars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }
}
