package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires = new Tire[4];

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    private void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    private void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    private void setTires(Tire[] tires) {
        this.tires = tires;
    }
}
