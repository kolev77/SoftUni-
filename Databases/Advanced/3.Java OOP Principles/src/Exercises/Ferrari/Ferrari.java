package Exercises.Ferrari;

/**
 * Created by Rostislav Kolev on 07-Jul-17.
 */
public class Ferrari implements Car {
    private static final String model = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    @Override

    public String getModel() {
        return model;
    }

    @Override
    public String pushBrakes() {
        return brakeMsg;
    }

    @Override
    public String pushGasPedal() {
        return gasMsg;
    }

    @Override
    public String getDriversName() {
        return this.driver;
    }


    @Override
    public String toString() {
        return this.getModel()+"/"+this.pushBrakes()+"/" + this.pushGasPedal()+"/"+this.getDriversName();
    }
}
