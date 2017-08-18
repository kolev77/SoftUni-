package NeedForSpeed.models.cars;

import java.util.List;

public class PerformanceCar extends Car {
    private List<String> _addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, (horsePower * 50) / 100, acceleration, suspension - ((suspension * 25) / 100), durability);
    }

    public List<String> getAddOns() {
        List<String> addOns = this._addOns;
        return addOns;
    }

    public void setAddOns(List<String> addOns) {
        this._addOns = addOns;
    }

    @Override
    public String toString() {
        if (_addOns.isEmpty())
            return super.toString() + "\nAdd-ons: None";
        else
            return super.toString() + String.join(", ",getAddOns());
    }
}
