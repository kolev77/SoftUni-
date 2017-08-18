package LAB.Exercises.CarSalesMan;

public class Engine {
    private static final String EFFICIENCY_DEFAULT = "n/a";
    private static final String DISPLACEMENT_DEFAULT = "n/a";
    private String model;
    private int power;
    private String displacement;        //optional
    private String efficiency;         //optional

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DISPLACEMENT_DEFAULT;
        this.efficiency = EFFICIENCY_DEFAULT;
    }

    public Engine(String model, int power,int displacement) {
        this(model, power);
        this.displacement = String.valueOf(displacement);
    }
    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, String displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public int getPower() {

        return power;
    }

    @Override
    public String toString() {
        return String.format("%s:\n    Power: %d\n    Displacement: %s\n    Efficiency: %s",
                            this.getModel(), this.getPower(), this.getDisplacement(), this.getEfficiency());
    }
}
