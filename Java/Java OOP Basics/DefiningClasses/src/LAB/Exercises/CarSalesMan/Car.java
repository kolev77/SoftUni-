package LAB.Exercises.CarSalesMan;

public class Car {
    private static final String WEIGHT_DEFAULT = "n/a";
    private static final String COLOR_DEFAULT = "n/a";
    private String model;
    private Engine engine;
    private String weight; // optional
    private String color; // optional

    public Car(String model, Engine engine){
        this.model= model;
        this.engine = engine;
        this.weight = WEIGHT_DEFAULT;
        this.color = COLOR_DEFAULT;
    }
    public Car(String model, Engine engine,int weight){
        this(model,engine);
        this.weight = String.valueOf(weight);
    }
    public Car(String model, Engine engine,String color){
        this(model,engine);
        this.color = color;
    }

    public Car(String model, Engine engine,String weight,String color){
        this(model,engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return String.format(
                "%s:\n  %s\n  Weight: %s\n  Color: %s",this.getModel(),this.getEngine(),this.getWeight(),this.getColor());
    }
}
