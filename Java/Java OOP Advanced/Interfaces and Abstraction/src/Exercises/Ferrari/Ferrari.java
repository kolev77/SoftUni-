package Exercises.Ferrari;

public class Ferrari implements Car {
    private static  final String MODEL = "488-Spider";
    private String driver;

    public Ferrari( String driver) {
        this.driver = driver;
    }

    @Override
    public String useBreaks() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }


    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.MODEL, this.useBreaks(), this.pushGas(), this.driver);
    }
}